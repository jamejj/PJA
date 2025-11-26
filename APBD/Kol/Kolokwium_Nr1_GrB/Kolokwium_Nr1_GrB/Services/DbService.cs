using Kolokwium_Nr1_GrB.Exceptions;
using Kolokwium_Nr1_GrB.ModelsDTO;
using Microsoft.Data.SqlClient;

namespace Kolokwium_Nr1_GrB.Services;

public class DbService : IDbService
{
    private readonly string _connectionString;
    public DbService(IConfiguration configuration)
    {
        _connectionString = configuration.GetConnectionString("Default") ?? string.Empty;
    }
    
//======================================================================================================================
//======================================================================================================================
    public async Task<VisitDto> GetVisitByIdAsync(int id)
    {
        var query = @"SELECT v.date, c.first_name, c.last_name, c.date_of_birth, m.mechanic_id, m.licence_number, s.name, vs.service_fee FROM Visit v
                      JOIN Client c ON v.client_id = c.client_id
                        JOIN Mechanic m ON v.mechanic_id = m.mechanic_id
                            JOIN Visit_Service vs ON vs.visit_id = v.visit_id
                                JOIN Service s ON s.service_id = vs.service_id
                                    WHERE v.visit_id = @id";

        await using var con = new SqlConnection(_connectionString);
        await using var cmd = new SqlCommand(query, con);
        cmd.Parameters.AddWithValue("@id", id);
        await con.OpenAsync();

        var reader = await cmd.ExecuteReaderAsync();
        VisitDto? result = null;

        while (await reader.ReadAsync())
        {
            if (result == null)
            {
                result = new VisitDto
                {
                    Date = reader.GetDateTime(0).ToString("yyyy-MM-ddTHH:mm:ss"),
                    Client = new ClientDto
                    {
                        FirstName = reader.GetString(1),
                        LastName = reader.GetString(2),
                        DateOfBirth = reader.GetDateTime(3).ToString("yyyy-MM-ddTHH:mm:ss")
                    },
                    Mechanic = new MechanicDto
                    {
                        MechanicId = reader.GetInt32(4),
                        LicenceNumber = reader.GetString(5)
                    },
                    VisitServices = new List<ServiceDto>()
                };
            }

            result.VisitServices.Add(new ServiceDto
            {
                Name = reader.GetString(6),
                ServiceFee = reader.GetDecimal(7)
            });
        }

        return result ?? throw new NotFoundException("404 Visit not found");
    }

//======================================================================================================================
//======================================================================================================================
  
//route -> api/visits
    public async Task AddVisitAsync(CreateVisitDto dto)
    {
        await using var con = new SqlConnection(_connectionString);
        await using var cmd = new SqlCommand();
        
        cmd.Connection = con;
        
        await con.OpenAsync();
        
        var transaction = await con.BeginTransactionAsync();
        cmd.Transaction = transaction as SqlTransaction;

        try
        {
//wizyta o podanym identyfikatorze
            cmd.CommandText = "SELECT 1 FROM Visit WHERE visit_id = @visit_id";
            cmd.Parameters.AddWithValue("@client_id", dto.VisitId);
            var visit = await cmd.ExecuteScalarAsync();
            if (visit == null)
                throw new NotFoundException("404 Visit not found");

//klient o podanym identyfikatorze
            cmd.CommandText = "SELECT 1 FROM Client WHERE client_id = @client_id";
            cmd.Parameters.AddWithValue("@client_id", dto.ClientId);
            var client = await cmd.ExecuteScalarAsync();
            if (client == null) 
                throw new NotFoundException("404 Client not found");
//mechanik o podanym numerze licencji
            cmd.Parameters.Clear();
            cmd.CommandText = "SELECT mechanic_id FROM Mechanic WHERE licence_number = @lic";
            cmd.Parameters.AddWithValue("@lic", dto.MechanicLicenceNumber);
            var mechanicId = await cmd.ExecuteScalarAsync();
            if (mechanicId == null) throw new NotFoundException("Mechanic not found");

 /*           
//serwis o podanej nazwie
            cmd.CommandText = "SELECT 1 FROM Service WHERE name = @name";
            cmd.Parameters.AddWithValue("@name", dto.Services);
            var name = await cmd.ExecuteScalarAsync();
            if (name == null) 
                throw new NotFoundException("404 Service not found");

//dane nie zgodne z walidacją

            cmd.Parameters.Clear();
            cmd.CommandText = "INSERT INTO Visit VALUES(@id, @client_id, @mech_id, @date)";
            cmd.Parameters.AddWithValue("@id", dto.VisitId);
            cmd.Parameters.AddWithValue("@client_id", dto.ClientId);
            cmd.Parameters.AddWithValue("@mech_id", mechanicId);
            cmd.Parameters.AddWithValue("@date", DateTime.Now);
            await cmd.ExecuteNonQueryAsync();
*/ 
 // -> w services
            
            foreach (var service in dto.Services)
            {
                cmd.Parameters.Clear();
                cmd.CommandText = "SELECT service_id FROM Service WHERE name = @name";
                cmd.Parameters.AddWithValue("@name", service.ServiceName);
                var serviceId = await cmd.ExecuteScalarAsync();
                if (serviceId == null) throw new NotFoundException("404 Service not found");

                cmd.Parameters.Clear();
                cmd.CommandText = "INSERT INTO Visit_Service VALUES(@visit_id, @service_id, @fee)";
                cmd.Parameters.AddWithValue("@visit_id", dto.VisitId);
                cmd.Parameters.AddWithValue("@service_id", serviceId);
                cmd.Parameters.AddWithValue("@fee", service.ServiceFee);
                await cmd.ExecuteNonQueryAsync();
            }

            await transaction.CommitAsync();
            
        }
        catch
        {
            await transaction.RollbackAsync();
            throw;
        }
    }
}
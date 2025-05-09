using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using Zadanie8.Model;

namespace Zadanie8.Controller;

[Route("api/[controller]")]
[ApiController]
public class ClientsController : ControllerBase
{
    private readonly IConfiguration _configuration;

    public ClientsController(IConfiguration configuration)
    {
        _configuration = configuration;
    }
    
//GET/api/clients/{id}/trips
    [HttpGet("{id}/trips")]
    public async Task<IActionResult> GetClientTripsById(int id)
    {
        var connectionString = _configuration.GetConnectionString("DefaultConnection");
        var trips = new List<object>();

        using var con = new SqlConnection(connectionString);
        using var com = new SqlCommand("SELECT * FROM Client c JOIN Client_Trip ct ON c.IdClient = ct.IdClient JOIN Trip t ON ct.IdTrip = t.IdTrip WHERE c.IdClient = @id", con);

        com.Parameters.AddWithValue("@id", id);

        await con.OpenAsync();
        using var reader = await com.ExecuteReaderAsync();

        if (!reader.HasRows)
            return NotFound("404");

        while (await reader.ReadAsync())
        {
            trips.Add(new
            {
                IdTrip = (int)reader["IdTrip"],
                Name = reader["Name"].ToString(),
                Description = reader["Description"].ToString(),
                DateFrom = reader["DateFrom"].ToString(),
                DateTo = reader["DateTo"].ToString(),
                MaxPeople = (int)reader["MaxPeople"],
                RegisteredAt = reader["RegisteredAt"].ToString(),
                PaymentDate = reader["PaymentDate"]?.ToString()
            });
        }

        return Ok(trips);
    }
    
//======================================================================================================================
    
//POST /api/clients
    [HttpPost]
    public async Task<IActionResult> ClienntAdd(Client client)
    {
        var connectionString = _configuration.GetConnectionString("DefaultConnection");

//sprawdzenie czy któreśpole jest puste
        if (string.IsNullOrEmpty(client.FirstName) ||
            string.IsNullOrEmpty(client.LastName) || 
                string.IsNullOrEmpty(client.Email) ||
                string.IsNullOrEmpty(client.Telephone) ||
                string.IsNullOrEmpty(client.Pesel))
        {        
                return BadRequest("400");
        }

        try
        {
            using var con = new SqlConnection(connectionString);
            using var com = new SqlCommand(@"INSERT INTO Client (FirstName, LastName, Email, Telephone, Pesel)
              VALUES (@FirstName, @LastName, @Email, @Telephone, @Pesel);", con);

            com.Parameters.AddWithValue("@FirstName", client.FirstName);
            com.Parameters.AddWithValue("@LastName", client.LastName);
            com.Parameters.AddWithValue("@Email", client.Email);
            com.Parameters.AddWithValue("@Telephone", client.Telephone);
            com.Parameters.AddWithValue("@Pesel", client.Pesel);

            await con.OpenAsync();
            await com.ExecuteNonQueryAsync();
            
            return StatusCode(201);

        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    /*
    [HttpGet("showClients")]
    public async Task<IActionResult> GetClients()
    {
        var clients = new List<Client>();
        var connectionString = _configuration.GetConnectionString("DefaultConnection");

        using var con = new SqlConnection(connectionString);
        using var com = new SqlCommand("SELECT * FROM Client", con);

        await con.OpenAsync();
        var reader = await com.ExecuteReaderAsync();

        while (await reader.ReadAsync())
        {
            var client = new Client
            {
                IdClient = (int)reader["IdClient"],
                FirstName = reader["FirstName"].ToString(),
                LastName = reader["LastName"].ToString(),
                Email = reader["Email"].ToString(),
                Telephone = reader["Telephone"].ToString(),
                Pesel = reader["Pesel"].ToString()
            };

            clients.Add(client);
        }

        return Ok(clients);
    }
    */
    
//DELETE /api/clients/{id}/trips/{tripid}
    [HttpDelete("{id}/trips/{tripId}")]
    public async Task<IActionResult> ClientTripDelete(int id, int tripId)
    {
        var connectionString = _configuration.GetConnectionString("DefaultConnection");
        using var con = new SqlConnection(connectionString);
        await con.OpenAsync();
        
//czy klient jedzie na wycieczke
        var check = new SqlCommand("SELECT 1 FROM Client_Trip WHERE IdClient = @id AND IdTrip = @tripId", con);
        check.Parameters.AddWithValue("@id", id);
        check.Parameters.AddWithValue("@tripId", tripId);
        
        var exists = await check.ExecuteScalarAsync();
        if (exists == null)
            return NotFound("404"); //jesli klient nie jest zapisany na wycieczke
        
//usuwanie
        var delete = new SqlCommand("DELETE FROM Client_Trip WHERE IdClient = @id AND IdTrip = @tripId", con);
        delete.Parameters.AddWithValue("@id", id);
        delete.Parameters.AddWithValue("@tripId", tripId);

        await delete.ExecuteNonQueryAsync();

        return Ok("OK");
    }
    
}
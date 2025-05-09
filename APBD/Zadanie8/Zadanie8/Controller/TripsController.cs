using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using Zadanie8.Model;

namespace Zadanie8.Controller;

[Route("api")]
[ApiController]
public class TripsController : ControllerBase
{
    private readonly IConfiguration _configuration;

    public TripsController(IConfiguration configuration)
    {
        _configuration = configuration;
    }
    
   
//======================================================================================================================
    
//1.GET/api/trips    
    [HttpGet("trips")]
    public async Task<IActionResult> GetTrips()
    {
        var trips = new List<Trip>();
        
        var connectionString = _configuration.GetConnectionString("DefaultConnection");
        
//try-catch do statusu
        try
        {
//początkowa konfiguracja
            using var con = new SqlConnection(connectionString);
            using var com = new SqlCommand("SELECT * FROM Trip", con);
            
//otwieramy połączenie
            await con.OpenAsync();
            SqlDataReader reader = await com.ExecuteReaderAsync();

//metoda do odczytwyania rekordów
            while (await reader.ReadAsync())
            {
                var trip = new Trip
                {
                    IdTrip = (int)reader["IdTrip"],
                    Name = (string)reader["Name"],
                    Description = (string)reader["Description"],
                    DateFrom = reader["DateFrom"].ToString(),
                    DateTo = reader["DateTo"].ToString(),
                    MaxPeople = (int)reader["MaxPeople"],
                };
                trips.Add(trip);
                
            }
        }
        catch (Exception e)
        {
            return StatusCode(500, "Internal Server Error");
        }
        return Ok(trips);
    }
    
}
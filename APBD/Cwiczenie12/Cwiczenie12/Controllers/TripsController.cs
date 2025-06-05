using Cwiczenie12.DTO;
using Cwiczenie12.Services;
using Microsoft.AspNetCore.Mvc;

namespace Cwiczenie12.Controllers;

[Route("api/[controller]")]
[ApiController]
public class TripsController : ControllerBase
{
    private readonly IDbService _db;
    public TripsController(IDbService db) => _db = db;

    [HttpGet]
    public async Task<IActionResult> GetTrips([FromQuery] int page = 1, [FromQuery] int pageSize = 10)
    {
        var (trips, totalCount) = await _db.GetTripsAsync(page, pageSize);
        return Ok(new
        {
            pageNum = page,
            pageSize,
            allPages = (int)Math.Ceiling(totalCount / (double)pageSize),
            trips
        });
    }

    [HttpPost("{idTrip}/clients")]
    public async Task<IActionResult> AddClientToTrip(int idTrip, [FromBody] CreateClientDto dto)
    {
        try
        {
            await _db.AddClientToTripAsync(idTrip, dto);
            return Ok("Client added to trip");
        }
        catch (Exception e)
        {
            return BadRequest(e.Message);
        }
    }
}
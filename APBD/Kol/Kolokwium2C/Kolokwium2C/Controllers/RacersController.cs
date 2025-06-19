using Kolokwium2C.DTOs;
using Kolokwium2C.Exceptions;
using Kolokwium2C.Services;
using Microsoft.AspNetCore.Mvc;

namespace Kolokwium2C.Controllers;

[ApiController]
[Route("api/racers")]
public class RacersController : ControllerBase
{
    private readonly IDbService _service;

    public RacersController(IDbService service)
    {
        _service = service;
    }

    [HttpGet("{id}/participations")]
    public async Task<IActionResult> GetParticipations(int id)
    {
        try
        {
            var result = await _service.GetRacerParticipationAsync(id);
            return Ok(result);
        }
        catch (NotFoundException ex)
        {
            return NotFound(ex.Message);
        }
    }

    [HttpPost("../track-races/participants")]
    public async Task<IActionResult> AddParticipants([FromBody] TrackRaceParticipantsRequest request)
    {
        try
        {
            await _service.AddParticipantsToTrackRaceAsync(request);
            return Created("", null);
        }
        catch (BadRequestException ex)
        {
            return BadRequest(ex.Message);
        }
    }
}

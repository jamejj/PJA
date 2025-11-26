using Kolokwium_Nr1_GrB.ModelsDTO;
using Kolokwium_Nr1_GrB.Services;
using Microsoft.AspNetCore.Mvc;

namespace Kolokwium_Nr1_GrB.Controllers;


[Route("api/[controller]")]
[ApiController]
public class VisitsController : ControllerBase
{
    private readonly IDbService _dbService;
    public VisitsController(IDbService dbService)
    {
        _dbService = dbService;
    }
//HttpGet route -> api/visits(controller)/{id}
    [HttpGet("{id}")]
    public async Task<IActionResult> Get(int id)
    {
        try
        {
            var result = await _dbService.GetVisitByIdAsync(id);
            return Ok(result);
        }
        catch (Exception e)
        {
            return NotFound(e.Message);
        }
    }
    
//======================================================================================================================
//======================================================================================================================

    [HttpPost]
    public async Task<IActionResult> Post(CreateVisitDto dto)
    {
        try
        {
            await _dbService.AddVisitAsync(dto);
            return Created("", dto);
        }
        catch (Exception e)
        {
            return BadRequest("Failed to create visit");
        }
    }
}

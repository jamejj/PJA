using Kolokwium2E.DTOs;
using Kolokwium2E.Services;
using Microsoft.AspNetCore.Mvc;

namespace Kolokwium2E.Controllers;

[ApiController]
[Route("api/nurseries")]
public class NurseriesController : ControllerBase
{
    private readonly IDbService _service;

    public NurseriesController(IDbService service)
    {
        _service = service;
    }

    [HttpGet("{id}/batches")]
    public async Task<ActionResult<NurseryDetailsDto>> GetWithBatches(int id)
    {
        try
        {
            var result = await _service.GetNurseryWithBatches(id);
            return Ok(result);
        }
        catch (Exception ex)
        {
            return NotFound(new { message = ex.Message });
        }
    }
}
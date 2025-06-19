using Kolokwium2E.DTOs;
using Kolokwium2E.Services;
using Microsoft.AspNetCore.Mvc;

namespace Kolokwium2E.Controllers;

[ApiController]
[Route("api/batches")]
public class BatchesController : ControllerBase
{
    private readonly IDbService _service;

    public BatchesController(IDbService service)
    {
        _service = service;
    }

    [HttpPost]
    public async Task<IActionResult> AddBatch([FromBody] CreateBatchDto dto)
    {
        try
        {
            await _service.AddBatch(dto);
            return Created("", null);
        }
        catch (Exception ex)
        {
            return BadRequest(new { message = ex.Message });
        }
    }
}
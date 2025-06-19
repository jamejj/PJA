using Kolokwium2F.DTOs;
using Kolokwium2F.Services;
using Microsoft.AspNetCore.Mvc;

namespace Kolokwium2F.Controllers;

[ApiController]
[Route("api/exhibitions")]
public class ExhibitionsController : ControllerBase
{
    private readonly IDbService _dbService;
    public ExhibitionsController(IDbService dbService) => _dbService = dbService;

    [HttpPost]
    public async Task<IActionResult> AddExhibition(CreateExhibitionRequest request)
    {
        try
        {
            await _dbService.AddExhibitionAsync(request);
            return Ok();
        }
        catch (Exception ex)
        {
            return BadRequest(new { error = ex.Message });
        }
    }
}

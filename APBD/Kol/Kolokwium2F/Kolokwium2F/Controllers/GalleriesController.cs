using Kolokwium2F.Services;
using Microsoft.AspNetCore.Mvc;

namespace Kolokwium2F.Controllers;

[ApiController]
[Route("api/galleries")]
public class GalleriesController : ControllerBase
{
    private readonly IDbService _dbService;

    public GalleriesController(IDbService dbService)
    {
        _dbService = dbService;
    }

    [HttpGet("{id}/exhibitions")]
    public async Task<IActionResult> GetExhibitions(int id)
    {
        try
        {
            var result = await _dbService.GetGalleryExhibitions(id);
            return Ok(result);
        }
        catch (Exception e)
        {
            return NotFound(e.Message);
        }
    }
}
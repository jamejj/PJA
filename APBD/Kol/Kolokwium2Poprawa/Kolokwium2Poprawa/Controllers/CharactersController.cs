using Kolokwium2Poprawa.DTOs;
using Kolokwium2Poprawa.Exceptions;
using Kolokwium2Poprawa.Services;
using Microsoft.AspNetCore.Mvc;

namespace Kolokwium2Poprawa.Controllers;

[ApiController]
[Route("api/characters")]
public class CharactersController : ControllerBase
{
    private readonly IDbService _dbService;

    public CharactersController(IDbService dbService)
    {
        _dbService = dbService;
    }

    [HttpGet("{characterId}")]
    public async Task<ActionResult<CharacterDto>> GetCharacter(int characterId)
    {
        try
        {
            var character = await _dbService.GetCharacterAsync(characterId);
            return Ok(character);
        }
        catch (NotFoundException ex)
        {
            return NotFound(ex.Message);
        }
    }

    [HttpPost("{characterId}/backpacks")]
    public async Task<IActionResult> AddToBackpack(int characterId, [FromBody] List<int> itemIds)
    {
        try
        {
            await _dbService.AddItemsToBackpackAsync(characterId, itemIds);
            return NoContent();
        }
        catch (NotFoundException ex)
        {
            return NotFound(ex.Message);
        }
        catch (BadRequestException ex)
        {
            return BadRequest(ex.Message);
        }
    }
}
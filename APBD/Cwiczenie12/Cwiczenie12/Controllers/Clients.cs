using Cwiczenie12.Services;
using Microsoft.AspNetCore.Mvc;

namespace Cwiczenie12.Controllers;

[Route("api/[controller]")]
[ApiController]
public class ClientsController : ControllerBase
{
    private readonly IDbService _db;
    public ClientsController(IDbService db) => _db = db;

    [HttpDelete("{idClient}")]
    public async Task<IActionResult> DeleteClient(int idClient)
    {
        try
        {
            await _db.DeleteClientAsync(idClient);
            return NoContent();
        }
        catch (Exception e)
        {
            return BadRequest(e.Message);
        }
    }
}
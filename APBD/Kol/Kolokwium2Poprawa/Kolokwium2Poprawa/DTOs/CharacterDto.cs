namespace Kolokwium2Poprawa.DTOs;

public class CharacterDto
{
    public string FirstName { get; set; } = null!;
    public string LastName { get; set; } = null!;
    public int CurrentWeight { get; set; }
    public int MaxWeight { get; set; }
    public List<BackpackItemDto> BackpackItems { get; set; } = new List<BackpackItemDto>();
    public List<CharacterTitleDto> Titles { get; set; } = new List<CharacterTitleDto>();
}
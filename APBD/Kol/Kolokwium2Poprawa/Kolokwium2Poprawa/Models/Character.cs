using System.ComponentModel.DataAnnotations;

namespace Kolokwium2Poprawa.Models;

public class Character
{
    public int CharacterId { get; set; } 
    [MaxLength(50)] 
    public string FirstName { get; set; } = null!;
    [MaxLength(120)] 
    public string LastName { get; set; } = null!;
    public int CurrentWeight { get; set; }
    public int MaxWeight { get; set; }
    
    public ICollection<Backpack> BackpackItems { get; set; } = new List<Backpack>();
    public ICollection<CharacterTitle> CharacterTitles { get; set; } = new List<CharacterTitle>();
}
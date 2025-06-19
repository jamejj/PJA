using System.ComponentModel.DataAnnotations;

namespace Kolokwium2Poprawa.Models;

public class Title
{
    public int TitleId { get; set; }
    [MaxLength(100)] 
    public string Name { get; set; } = null!;
    
    public ICollection<CharacterTitle> CharacterTitles { get; set; } = new List<CharacterTitle>();
}
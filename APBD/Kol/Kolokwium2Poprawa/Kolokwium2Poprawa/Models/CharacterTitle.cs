using System.ComponentModel.DataAnnotations.Schema;

namespace Kolokwium2Poprawa.Models;

[Table("Character_Title")]
public class CharacterTitle
{
    public int CharacterId { get; set; }
    public Character Character { get; set; } = null!;
    
    public int TitleId { get; set; }
    public Title Title { get; set; } = null!;
    
    public DateTime AcquiredAt { get; set; }
}
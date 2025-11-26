using System.ComponentModel.DataAnnotations;

namespace Kolokwium2C_Poprawa.Models;

public class Racer
{
    [Key] 
    public int RacerId { get; set; }
    [MaxLength(50)] 
    public string FirstName { get; set; } = null!;
    [MaxLength(100)] 
    public string LastName { get; set; } = null!;
    public ICollection<RaceParticipation> Participations { get; set; } = new List<RaceParticipation>();
}
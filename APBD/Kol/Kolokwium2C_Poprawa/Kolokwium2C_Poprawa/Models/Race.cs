using System.ComponentModel.DataAnnotations;

namespace Kolokwium2C_Poprawa.Models;

public class Race
{
    [Key] 
    public int RaceId { get; set; }
    [MaxLength(50)] public string Name { get; set; } = null!;
    [MaxLength(100)] public string Location { get; set; } = null!;
    public DateTime Date { get; set; }

    public ICollection<TrackRace> TrackRaces { get; set; } = new List<TrackRace>();
}
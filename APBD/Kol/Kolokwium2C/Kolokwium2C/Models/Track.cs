using System.ComponentModel.DataAnnotations;

namespace Kolokwium2C.Models;

public class Track
{
    [Key] public int TrackId { get; set; }
    [MaxLength(100)] 
    public string Name { get; set; } = null!;
    public decimal LengthInKm { get; set; }

    public ICollection<TrackRace> TrackRaces { get; set; } = new List<TrackRace>();
}
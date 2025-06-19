using System.ComponentModel.DataAnnotations.Schema;

namespace Kolokwium2C.Models;

[Table("Track_Race")]
public class TrackRace
{
    public int TrackId { get; set; }
    public Track Track { get; set; } = null!;
    public int RaceId { get; set; }
    public Race Race { get; set; } = null!;
    public int Laps { get; set; }
    public int BestTimeInSeconds { get; set; }
    public ICollection<RaceParticipation> RaceParticipations { get; set; } = new List<RaceParticipation>();
}


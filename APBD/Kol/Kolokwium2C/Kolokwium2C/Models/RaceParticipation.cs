using System.ComponentModel.DataAnnotations.Schema;

namespace Kolokwium2C.Models;

[Table("Race_Participation")]
public class RaceParticipation
{
    public int RaceId { get; set; }
    public Race Race { get; set; }
    public int TrackId { get; set; }
    public Track Track { get; set; }
    public int RacerId { get; set; }
    public Racer Racer { get; set; }
    public int FinishTimeInSeconds { get; set; }
    public int Position { get; set; }
}

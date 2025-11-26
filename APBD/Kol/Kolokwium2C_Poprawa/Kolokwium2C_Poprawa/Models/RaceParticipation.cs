using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace Kolokwium2C_Poprawa.Models;

[Table("Race_Participation")]
[PrimaryKey(nameof(TrackId), nameof(RacerId))]
public class RaceParticipation
{
    
    
    public int RaceId { get; set; }

    public Race Race { get; set; } = null!;
    
    [ForeignKey(nameof(TrackRace))]
    public int TrackId { get; set; }
    public Track Track { get; set; } = null!;
    
   [ForeignKey(nameof(Racer))]
    public int RacerId { get; set; }
    public Racer Racer { get; set; } = null!;
    public int FinishTimeInSeconds { get; set; }
    public int Position { get; set; }
}
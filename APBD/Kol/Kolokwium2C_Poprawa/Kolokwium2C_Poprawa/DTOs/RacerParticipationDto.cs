namespace Kolokwium2C_Poprawa.DTOs;

public class RacerParticipationDto
{
    public string RaceName { get; set; } = null!;
    public string TrackName { get; set; } = null!;
    public int Laps { get; set; }
    public int BestTimeInSeconds { get; set; }
    public int FinishTimeInSeconds { get; set; }
    public int Position { get; set; }
}
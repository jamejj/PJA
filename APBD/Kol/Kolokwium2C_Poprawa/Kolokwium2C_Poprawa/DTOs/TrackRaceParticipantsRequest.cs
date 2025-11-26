namespace Kolokwium2C_Poprawa.DTOs;

public class TrackRaceParticipantsRequest
{
    public string RaceName { get; set; } = null!;
    public string TrackName { get; set; } = null!;
    public List<ParticipantEntryDto> Participations { get; set; } = new();
}
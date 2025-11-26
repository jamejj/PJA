namespace Kolokwium2C_Poprawa.DTOs;

public class RacerDto
{
    public int RacerId { get; set; }
    public string FirstName { get; set; } = null!;
    public string LastName { get; set; } = null!;
    public List<RacerParticipationDto> Participations { get; set; } = new();
}
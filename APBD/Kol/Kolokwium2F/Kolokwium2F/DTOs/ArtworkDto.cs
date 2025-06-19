namespace Kolokwium2F.DTOs;

public class ArtworkDto
{
    public string Title { get; set; } = null!;
    public int YearCreated { get; set; }
    public decimal InsuranceValue { get; set; }
    public ArtistDto Artist { get; set; } = null!;
}
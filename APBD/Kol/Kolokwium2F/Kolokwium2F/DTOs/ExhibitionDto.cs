namespace Kolokwium2F.DTOs;

public class ExhibitionDto
{
    public string Title { get; set; } = null!;
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public int NumberOfArtworks { get; set; }
    public List<ArtworkDto> Artworks { get; set; } = new();
}
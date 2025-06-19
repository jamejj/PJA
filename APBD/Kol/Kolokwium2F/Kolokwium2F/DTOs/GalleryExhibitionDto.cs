namespace Kolokwium2F.DTOs;

public class GalleryExhibitionDto
{
    public int GalleryId { get; set; }
    public string Name { get; set; } = null!;
    public DateTime EstablishedDate { get; set; }
    public List<ExhibitionDto> Exhibitions { get; set; } = new();
}

using System.ComponentModel.DataAnnotations;

namespace Kolokwium2F.Models;

public class Exhibition
{
    [Key]
    public int ExhibitionId { get; set; }
    public int GalleryId { get; set; }
    [MaxLength(100)]
    public string Title { get; set; } = null!;
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public int NumberOfArtworks { get; set; }
    public Gallery Gallery { get; set; } = null!;
    public ICollection<ExhibitionArtwork> ExhibitionArtworks { get; set; } = new List<ExhibitionArtwork>();
}
using System.ComponentModel.DataAnnotations;

namespace Kolokwium2F.Models;

public class Artwork
{
    [Key]
    public int ArtworkId { get; set; }
    public int ArtistId { get; set; }
    [MaxLength(100)]
    public string Title { get; set; } = null!;
    public int YearCreated { get; set; }
    public Artist Artist { get; set; } = null!;
    public ICollection<ExhibitionArtwork> ExhibitionArtworks { get; set; } = new List<ExhibitionArtwork>();
}

using System.ComponentModel.DataAnnotations;

namespace Kolokwium2F.Models;

public class Artist
{
    [Key]
    public int ArtistId { get; set; }
    [MaxLength(100)]
    public string FirstName { get; set; } = null!;
    [MaxLength(100)]
    public string LastName { get; set; } = null!;
    public DateTime BirthDate { get; set; }
    public ICollection<Artwork> Artworks { get; set; } = new List<Artwork>();
}

using System.ComponentModel.DataAnnotations.Schema;

namespace Kolokwium2F.Models;

[Table("Exhibition_Artwork")]
public class ExhibitionArtwork
{
    public int ExhibitionId { get; set; }
    public int ArtworkId { get; set; }

    public decimal InsuranceValue { get; set; }

    public Exhibition Exhibition { get; set; } = null!;
    public Artwork Artwork { get; set; } = null!;
}

using System.ComponentModel.DataAnnotations;

namespace Kolokwium2F.DTOs;

public class ExhibitionArtworkDto
{
    [Required]
    public int ArtworkId { get; set; }
    [Required]
    public decimal InsuranceValue { get; set; }
}
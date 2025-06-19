using System.ComponentModel.DataAnnotations;

namespace Kolokwium2F.DTOs;

public class CreateExhibitionRequest
{
    [Required]
    public string Title { get; set; } = null!;
    [Required]
    public string Gallery { get; set; } = null!;
    [Required]
    public DateTime StartDate { get; set; }
    [Required]
    public DateTime EndDate { get; set; }
    [Required]
    public List<ExhibitionArtworkDto> Artworks { get; set; } = new();
}
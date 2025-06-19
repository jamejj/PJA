using System.ComponentModel.DataAnnotations;

namespace Kolokwium2F.Models;

public class Gallery
{
    [Key] public int GalleryId { get; set; }
    [MaxLength(50)] public string Name { get; set; } = null!;
    public DateTime EstablishedDate { get; set; }
    public ICollection<Exhibition> Exhibitions { get; set; } = new List<Exhibition>();
}
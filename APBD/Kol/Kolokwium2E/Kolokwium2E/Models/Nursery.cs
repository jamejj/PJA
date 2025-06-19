using System.ComponentModel.DataAnnotations;

namespace Kolokwium2E.Models;

public class Nursery
{
    [Key]
    public int NurseryId { get; set; }
    public string Name { get; set; } = null!;
    public DateTime EstablishedDate { get; set; }

    public ICollection<SeedlingBatch> Batches { get; set; } = new List<SeedlingBatch>();
}
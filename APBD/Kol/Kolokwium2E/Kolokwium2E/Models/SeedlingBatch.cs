using System.ComponentModel.DataAnnotations;

namespace Kolokwium2E.Models;

public class SeedlingBatch
{
    [Key]
    public int BatchId { get; set; }
    public int NurseryId { get; set; }
    public int SpeciesId { get; set; }
    public int Quantity { get; set; }
    public DateTime SownDate { get; set; }
    public DateTime? ReadyDate { get; set; }

    public Nursery Nursery { get; set; } = null!;
    public TreeSpecies Species { get; set; } = null!;
    public ICollection<Responsible> Responsible { get; set; } = new List<Responsible>();
}
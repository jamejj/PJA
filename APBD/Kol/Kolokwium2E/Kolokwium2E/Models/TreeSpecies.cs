using System.ComponentModel.DataAnnotations;

namespace Kolokwium2E.Models;

public class TreeSpecies
{
    [Key]
    public int SpeciesId { get; set; }
    public string LatinName { get; set; } = null!;
    public int GrowthTimeInYears { get; set; }

    public ICollection<SeedlingBatch> Batches { get; set; } = new List<SeedlingBatch>();
}
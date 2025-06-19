using System.ComponentModel.DataAnnotations;

namespace Kolokwium2E.Models;

public class Responsible
{
    [Key]
    public int BatchId { get; set; }
    public int EmployeeId { get; set; }
    public string Role { get; set; } = null!;

    public SeedlingBatch Batch { get; set; } = null!;
    public Employee Employee { get; set; } = null!;
}
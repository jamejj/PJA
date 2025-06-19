using System.ComponentModel.DataAnnotations;

namespace Kolokwium2E.Models;

public class Employee
{
    [Key]
    public int EmployeeId { get; set; }
    public string FirstName { get; set; } = null!;
    public string LastName { get; set; } = null!;
    public DateTime HireDate { get; set; }

    public ICollection<Responsible> Responsibles { get; set; } = new List<Responsible>();
}
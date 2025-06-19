using Kolokwium2E.Models;
using Microsoft.EntityFrameworkCore;

namespace Kolokwium2E.Data;

public class DatabaseContext : DbContext
{
    public DbSet<Nursery> Nurseries { get; set; }
    public DbSet<SeedlingBatch> Batches { get; set; }
    public DbSet<TreeSpecies> Species { get; set; }
    public DbSet<Employee> Employees { get; set; }
    public DbSet<Responsible> Responsibles { get; set; }

    public DatabaseContext(DbContextOptions<DatabaseContext> options) : base(options) { }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Responsible>()
            .HasKey(r => new { r.BatchId, r.EmployeeId });

        modelBuilder.Entity<Nursery>().HasData(
            new Nursery
            {
                NurseryId = 1,
                Name = "Green Forest Nursery",
                EstablishedDate = new DateTime(2005, 5, 10)
            }
        );

        modelBuilder.Entity<TreeSpecies>().HasData(
            new TreeSpecies
            {
                SpeciesId = 1,
                LatinName = "Quercus robur",
                GrowthTimeInYears = 5
            }
        );

        modelBuilder.Entity<Employee>().HasData(
            new Employee
            {
                EmployeeId = 1,
                FirstName = "Anna",
                LastName = "Kowalska",
                HireDate = new DateTime(2020, 1, 1)
            },
            new Employee
            {
                EmployeeId = 3,
                FirstName = "Jan",
                LastName = "Nowak",
                HireDate = new DateTime(2019, 6, 15)
            }
        );

        modelBuilder.Entity<SeedlingBatch>().HasData(
            new SeedlingBatch
            {
                BatchId = 1,
                NurseryId = 1,
                SpeciesId = 1,
                Quantity = 500,
                SownDate = new DateTime(2024, 3, 15),
                ReadyDate = new DateTime(2029, 3, 15)
            }
        );

        modelBuilder.Entity<Responsible>().HasData(
            new Responsible
            {
                BatchId = 1,
                EmployeeId = 1,
                Role = "Supervisor"
            },
            new Responsible
            {
                BatchId = 1,
                EmployeeId = 3,
                Role = "Planter"
            }
        );
    }
}
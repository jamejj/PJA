using Kolokwium2E.Data;
using Kolokwium2E.DTOs;
using Kolokwium2E.Models;
using Microsoft.EntityFrameworkCore;

namespace Kolokwium2E.Services;

public class DbService : IDbService
{
    private readonly DatabaseContext _context;

    public DbService(DatabaseContext context)
    {
        _context = context;
    }

    public async Task<NurseryDetailsDto> GetNurseryWithBatches(int nurseryId)
    {
        var nursery = await _context.Nurseries
            .Where(n => n.NurseryId == nurseryId)
            .Select(n => new NurseryDetailsDto
            {
                NurseryId = n.NurseryId,
                Name = n.Name,
                EstablishedDate = n.EstablishedDate,
                Batches = n.Batches.Select(b => new BatchDto
                {
                    BatchId = b.BatchId,
                    Quantity = b.Quantity,
                    SownDate = b.SownDate,
                    ReadyDate = b.ReadyDate,
                    Species = new SpeciesDto
                    {
                        LatinName = b.Species.LatinName,
                        GrowthTimeInYears = b.Species.GrowthTimeInYears
                    },
                    Responsible = b.Responsible.Select(r => new ResponsibleDto
                    {
                        FirstName = r.Employee.FirstName,
                        LastName = r.Employee.LastName,
                        Role = r.Role
                    }).ToList()
                }).ToList()
            })
            .FirstOrDefaultAsync();

        if (nursery == null)
            throw new Exception("Nursery not found");

        return nursery;
    }

    public async Task AddBatch(CreateBatchDto dto)
    {
        var species = await _context.Species.FirstOrDefaultAsync(s => s.LatinName == dto.Species);
        if (species == null)
            throw new Exception("Species not found");

        var nursery = await _context.Nurseries.FirstOrDefaultAsync(n => n.Name == dto.Nursery);
        if (nursery == null)
            throw new Exception("Nursery not found");

        foreach (var r in dto.Responsible)
        {
            var employeeExists = await _context.Employees.AnyAsync(e => e.EmployeeId == r.EmployeeId);
            if (!employeeExists)
                throw new Exception($"Employee with ID {r.EmployeeId} not found");
        }

        var batch = new SeedlingBatch
        {
            Quantity = dto.Quantity,
            NurseryId = nursery.NurseryId,
            SpeciesId = species.SpeciesId,
            SownDate = DateTime.UtcNow,
            ReadyDate = DateTime.UtcNow.AddYears(species.GrowthTimeInYears),
        };

        _context.Batches.Add(batch);
        await _context.SaveChangesAsync();

        foreach (var r in dto.Responsible)
        {
            _context.Responsibles.Add(new Responsible
            {
                BatchId = batch.BatchId,
                EmployeeId = r.EmployeeId,
                Role = r.Role
            });
        }

        await _context.SaveChangesAsync();
    }
}
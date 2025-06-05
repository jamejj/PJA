using Cwiczenie12.Data;
using Cwiczenie12.DTO;
using Cwiczenie12.Models;
using Microsoft.EntityFrameworkCore;

namespace Cwiczenie12.Services;

public class DbService : IDbService
{
    private readonly Apbd12Context _context;
    public DbService(Apbd12Context context)
    {
        _context = context;
    }

    public async Task<(List<TripDto>, int)> GetTripsAsync(int page, int pageSize)
    {
        var query = _context.Trips
            .Include(t => t.ClientTrips)
                .ThenInclude(ct => ct.IdClientNavigation)
            .Include(t => t.IdCountries)
            .OrderByDescending(t => t.DateFrom);

        var totalCount = await query.CountAsync();
        var trips = await query
            .Skip((page - 1) * pageSize)
            .Take(pageSize)
            .Select(t => new TripDto
            {
                Name = t.Name,
                Description = t.Description,
                DateFrom = t.DateFrom,
                DateTo = t.DateTo,
                MaxPeople = t.MaxPeople,
                Countries = t.IdCountries.Select(c => new CountryDto { Name = c.Name }).ToList(),
                Clients = t.ClientTrips.Select(ct => new ClientDto
                {
                    FirstName = ct.IdClientNavigation.FirstName,
                    LastName = ct.IdClientNavigation.LastName
                }).ToList()
            })
            .ToListAsync();

        return (trips, totalCount);
    }

    public async Task DeleteClientAsync(int idClient)
    {
        var client = await _context.Clients
            .Include(c => c.ClientTrips)
            .FirstOrDefaultAsync(c => c.IdClient == idClient);

        if (client is null)
            throw new Exception("Client not found");

        if (client.ClientTrips.Any())
            throw new Exception("Client has assigned trips");

        _context.Clients.Remove(client);
        await _context.SaveChangesAsync();
    }

    public async Task AddClientToTripAsync(int idTrip, CreateClientDto dto)
    {
        var trip = await _context.Trips.FindAsync(idTrip);
        if (trip is null)
            throw new Exception("Trip not found");

        var existingClient = await _context.Clients
            .FirstOrDefaultAsync(c => c.Pesel == dto.Pesel);

        if (existingClient is null)
        {
            existingClient = new Client
            {
                FirstName = dto.FirstName,
                LastName = dto.LastName,
                Email = dto.Email,
                Telephone = dto.Telephone,
                Pesel = dto.Pesel
            };

            _context.Clients.Add(existingClient);
            await _context.SaveChangesAsync();
        }

        if (await _context.ClientTrips.AnyAsync(ct => ct.IdClient == existingClient.IdClient && ct.IdTrip == idTrip))
            throw new Exception("Client is already assigned to this trip");

        var clientTrip = new ClientTrip
        {
            IdClient = existingClient.IdClient,
            IdTrip = idTrip,
            RegisteredAt = DateTime.Now,
            PaymentDate = dto.PaymentDate
        };

        _context.ClientTrips.Add(clientTrip);
        await _context.SaveChangesAsync();
    }
}
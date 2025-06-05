using Cwiczenie12.DTO;

namespace Cwiczenie12.Services;

public interface IDbService
{
    Task<(List<TripDto>, int)> GetTripsAsync(int page, int pageSize);
    Task DeleteClientAsync(int idClient);
    Task AddClientToTripAsync(int idTrip, CreateClientDto dto);
}
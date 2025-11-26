using Kolokwium_Nr1_GrB.ModelsDTO;

namespace Kolokwium_Nr1_GrB.Services;

public interface IDbService
{
    Task<VisitDto> GetVisitByIdAsync(int id);
    Task AddVisitAsync(CreateVisitDto dto);
}
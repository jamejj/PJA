using Kolokwium2E.DTOs;

namespace Kolokwium2E.Services;

public interface IDbService
{
    Task<NurseryDetailsDto> GetNurseryWithBatches(int nurseryId);
    Task AddBatch(CreateBatchDto dto);
}
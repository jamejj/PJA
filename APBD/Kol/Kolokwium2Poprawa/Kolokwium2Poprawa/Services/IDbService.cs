using Kolokwium2Poprawa.DTOs;

namespace Kolokwium2Poprawa.Services;

public interface IDbService
{
    Task<CharacterDto> GetCharacterAsync(int characterId);
    Task AddItemsToBackpackAsync(int characterId, List<int> itemIds);
}
using Kolokwium2Poprawa.Data;
using Kolokwium2Poprawa.DTOs;
using Kolokwium2Poprawa.Exceptions;
using Kolokwium2Poprawa.Models;
using Microsoft.EntityFrameworkCore;

namespace Kolokwium2Poprawa.Services;

public class DbService : IDbService
{
    private readonly DatabaseContext _context;

    public DbService(DatabaseContext context) 
        => _context = context;

    public async Task<CharacterDto> GetCharacterAsync(int characterId)
    {
        var character = await _context.Characters
            .Include(c => c.BackpackItems).ThenInclude(b => b.Item)
            .Include(c => c.CharacterTitles).ThenInclude(ct => ct.Title)
            .FirstOrDefaultAsync(c => c.CharacterId == characterId);

        return character == null 
            ? throw new Exception("Character not found") 
            : new CharacterDto
            {
                FirstName = character.FirstName,
                LastName = character.LastName,
                CurrentWeight = character.CurrentWeight,
                MaxWeight = character.MaxWeight,
                BackpackItems = character.BackpackItems.Select(b => new BackpackItemDto
                {
                    ItemName = b.Item.Name,
                    ItemWeight = b.Item.Weight,
                    Amount = b.Amount
                }).ToList(),
                Titles = character.CharacterTitles.Select(ct => new CharacterTitleDto
                {
                    Title = ct.Title.Name,
                    AcquiredAt = ct.AcquiredAt
                }).ToList()
            };
    }

    public async Task AddItemsToBackpackAsync(int characterId, List<int> itemIds)
    {
        var character = await _context.Characters
            .Include(c => c.BackpackItems)
            .FirstOrDefaultAsync(c => c.CharacterId == characterId) 
            ?? throw new NotFoundException("Character not found");

        var items = await _context.Items
            .Where(i => itemIds.Contains(i.ItemId))
            .ToListAsync();

        if (items.Count != itemIds.Count)
            throw new Exception("Some items don't exist");

        var totalWeight = items.Sum(i => i.Weight);
        if (character.CurrentWeight + totalWeight > character.MaxWeight)
            throw new Exception("Not enough capacity");

        foreach (var item in items)
        {
            var existingItem = character.BackpackItems.FirstOrDefault(b => b.ItemId == item.ItemId);
            if (existingItem != null) existingItem.Amount++;
            else character.BackpackItems.Add(new Backpack { ItemId = item.ItemId, Amount = 1 });
        }
        character.CurrentWeight += totalWeight;
        await _context.SaveChangesAsync();
    }
}
using System.ComponentModel.DataAnnotations;

namespace Kolokwium2Poprawa.Models;

public class Item
{
    public int ItemId { get; set; }
    [MaxLength(100)] 
    public string Name { get; set; } = null!;
    public int Weight { get; set; }
    
    public ICollection<Backpack> Backpacks { get; set; } = new List<Backpack>();
}
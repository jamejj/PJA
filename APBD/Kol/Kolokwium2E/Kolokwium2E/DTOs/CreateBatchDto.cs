namespace Kolokwium2E.DTOs;

public class CreateBatchDto
{
    public string Species { get; set; } = null!;
    public string Nursery { get; set; } = null!;
    public int Quantity { get; set; }
    public List<CreateResponsibleDto> Responsible { get; set; } = new();
}
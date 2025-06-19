namespace Kolokwium2E.DTOs;

public class NurseryDetailsDto
{
    public int NurseryId { get; set; }
    public string Name { get; set; } = null!;
    public DateTime EstablishedDate { get; set; }
    public List<BatchDto> Batches { get; set; } = new();
}
namespace Kolokwium_Nr1_GrB.ModelsDTO;

public class CreateVisitDto
{
    public int VisitId { get; set; }
    public int ClientId { get; set; }
    public string MechanicLicenceNumber { get; set; } = string.Empty;
    public List<ServiceInputDto> Services { get; set; } = new();
}

public class ServiceInputDto
{
    public string ServiceName { get; set; } = string.Empty;
    public decimal ServiceFee { get; set; }
}
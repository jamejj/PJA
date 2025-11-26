namespace Kolokwium_Nr1_GrB.ModelsDTO;

public class VisitDto
{
    public string Date { get; set; } = string.Empty;
    public ClientDto Client { get; set; } = new();
    public MechanicDto Mechanic { get; set; } = new();
    public List<ServiceDto> VisitServices { get; set; } = new();
}

public class ClientDto
{
    public string FirstName { get; set; } = string.Empty;
    public string LastName { get; set; } = string.Empty;
    public string DateOfBirth { get; set; } = string.Empty;
}
public class MechanicDto
{
    public int MechanicId { get; set; }
    public string LicenceNumber { get; set; } = string.Empty;
}
public class ServiceDto
{
    public string Name { get; set; } = string.Empty;
    public decimal ServiceFee { get; set; }
}

namespace APBD_Kontenery;


public class Kontener
{
    public double MasaLadunku { get; protected set; }
    public int Wysokosc{ get; set; }
    public int WagaWlasnaKontenera { get; set; }
    public int Glebokosc { get; set; }
    public string NumerSeryjny { get; set; }

    public double MaxLadownoscKontenera { get; set; }

    private static int _numerSeryjnyCount = 1;

    protected Kontener(string typ, double masaLadunku, int wysokosc, int wagaWlasnaKontenera, int glebokosc, double maxLadownoscKontenera)
    {
        MasaLadunku = masaLadunku;
        Wysokosc = wysokosc;
        WagaWlasnaKontenera = wagaWlasnaKontenera;
        Glebokosc = glebokosc;
        NumerSeryjny = $"KON-{typ}-{_numerSeryjnyCount++}";
        MaxLadownoscKontenera = maxLadownoscKontenera;
    }

    public virtual void Oproznij()
    {
        MasaLadunku = 0;
        Console.WriteLine("Kontener: " + NumerSeryjny + " został opróżniony");
    }
    public virtual void Zaladuj(double ciezar)
    {
        if (ciezar > MaxLadownoscKontenera)
        {
            throw new OverflowException("Przekroczono ładowność kontenera");
        }

        MasaLadunku = (int)ciezar;
    } 
    
    public void WypiszInfo()
    {
        Console.WriteLine($"Kontener: {NumerSeryjny}");
        Console.WriteLine($"Masa ładunku: {MasaLadunku} kg");
        Console.WriteLine($"Wysokość: {Wysokosc} cm");
        Console.WriteLine($"Głębokość: {Glebokosc} cm");
        Console.WriteLine($"Waga własna: {WagaWlasnaKontenera} kg");
        Console.WriteLine($"Max ładowność: {MaxLadownoscKontenera} kg");
    }
    

}
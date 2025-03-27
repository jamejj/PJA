namespace APBD_Kontenery;

public class KontenerNaPlyny : Kontener, IHazardNotifier
{
    private bool CzyLadunekNiebezpieczny{get;set;}

    public KontenerNaPlyny(int masaLadunku, int wysokosc, int wagaWlasnaKontenera, int glebokosc, int maxLadownoscKontenera, bool czyLadunekNiebezpieczny) : base("L", masaLadunku, wysokosc, wagaWlasnaKontenera, glebokosc, maxLadownoscKontenera)
    {
        CzyLadunekNiebezpieczny = czyLadunekNiebezpieczny;
    }

    public void NotifyHazard()
    {
        Console.WriteLine($"Niebezpieczna sytuacja {NumerSeryjny}");
    }
    
    
    public override void Zaladuj(double ciezar)
    {
        double pojemnosc = 0;
        
        if (CzyLadunekNiebezpieczny == true)
        {
            pojemnosc = MaxLadownoscKontenera * 0.5;
        }
        else
        {
            pojemnosc = MaxLadownoscKontenera * 0.9;
        }

        if (ciezar > pojemnosc)
        {
            NotifyHazard();
            throw new OverflowException("Przekroczono ładowność kontenera");
        }

        MasaLadunku += (int) ciezar;
        Console.WriteLine($"Kontener {NumerSeryjny} załadowany {MasaLadunku}");
    }

}
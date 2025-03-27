namespace APBD_Kontenery;

public class KontenerNaGaz : Kontener, IHazardNotifier
{

    private int CisnienieWAtmosferach { get; set; }

    public KontenerNaGaz(double masaLadunku, int wysokosc, int wagaWlasnaKontenera, int glebokosc, double maxLadownoscKontenera, int cisnienieWAtmosferach) : base("G", masaLadunku, wysokosc, wagaWlasnaKontenera,
        glebokosc, maxLadownoscKontenera)
    {
        CisnienieWAtmosferach = cisnienieWAtmosferach;
    }

    public void NotifyHazard()
    {
        Console.WriteLine($"Niebezpieczna sytuacja {NumerSeryjny} cisnienie gazu w kontenerze {CisnienieWAtmosferach} atmosfer");
    }

    public override void Oproznij()
    {
        double pozostalosc = MasaLadunku * 0.05;
        MasaLadunku = pozostalosc;
        Console.WriteLine($"Kontener: {NumerSeryjny} został opróżniony w 95% aktualna masa ladunku - {MasaLadunku}");

    }


    public override void Zaladuj(double ciezar)
    {
        if (ciezar > MaxLadownoscKontenera)
        {
            NotifyHazard();
            throw new OverflowException("Przekroczono ładowność kontenera");
        }

        MasaLadunku += (int)ciezar;
        Console.WriteLine($"Kontener {NumerSeryjny} załadowany {MasaLadunku}");

    }
}



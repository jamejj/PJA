namespace APBD_Kontenery;

public class Statek
{
    private List<Kontener> Kontenery { get; set; }
    private int MaxymalnaPredkoscStatku { get; set; }
    private int MaxLiczbaKontenerow { get; set; }
    private int MaxObciazenie { get; set; }

    public Statek(int maxymalnaPredkoscStatku, int maxLiczbaKontenerow, int maxObciazenie)
    {
        Kontenery = new List<Kontener>();;
        MaxymalnaPredkoscStatku = maxymalnaPredkoscStatku;
        MaxLiczbaKontenerow = maxLiczbaKontenerow;
        MaxObciazenie = maxObciazenie;
    }

    public void ZaładujKontenerNaStatek(Kontener kontener)
    {
        double lacznaWaga = 0;
        
        foreach (var k in Kontenery)
        {
            lacznaWaga += k.MasaLadunku + k.WagaWlasnaKontenera;
        }

        if (lacznaWaga + kontener.MasaLadunku + kontener.WagaWlasnaKontenera > MaxObciazenie * 1000)
        {
            throw new OverfillException("Przekroczono ładownosc statku");
        }

        Kontenery.Add(kontener);
        Console.WriteLine($"Dodano kontener {kontener.NumerSeryjny}");
    }


    public void UsunKontener(string numerSeryjny)
    {
        Kontener? doUsuniecia = null;

        foreach (var k in Kontenery)
        {
            if (k.NumerSeryjny == numerSeryjny)
            { 
                doUsuniecia = k;
            }
        }
        if (doUsuniecia != null)
        {
            Kontenery.Remove(doUsuniecia);
            Console.WriteLine($"Usunięto kontener: {numerSeryjny} ze statku");
        }
        else
        {
            Console.WriteLine("Nie znaleziono kontenera.");
        }
    }
    
    public void ZastapKontener(string numerDoZamiany, Kontener nowyKontener)
    {
        for (int i = 0; i < Kontenery.Count; i++)
        {
            if (Kontenery[i].NumerSeryjny == numerDoZamiany)
            {
                Kontenery[i] = nowyKontener;
                Console.WriteLine($"Kontener {numerDoZamiany} został zastąpiony przez {nowyKontener.NumerSeryjny}");
                return;
            }
        }

        Console.WriteLine("Nie znaleziono kontenera do zastąpienia.");
    }
    
    public void PrzeniesKontenerNa(Statek innyStatek, string numerSeryjny)
    {
        Kontener doPrzeniesienia = null;

        foreach (var k in Kontenery)
        {
            if (k.NumerSeryjny == numerSeryjny)
            {
                doPrzeniesienia = k;
                break;
            }
        }

        if (doPrzeniesienia != null)
        {
            innyStatek.ZaładujKontenerNaStatek(doPrzeniesienia);
            Kontenery.Remove(doPrzeniesienia);
            Console.WriteLine($"Przeniesiono kontener {numerSeryjny} na inny statek.");
        }
        else
        {
            Console.WriteLine("Nie znaleziono kontenera do przeniesienia.");
        }
    }

    public void StatekInfo()
    {
        Console.WriteLine($"Prędkość: {MaxymalnaPredkoscStatku} węzłów");
        Console.WriteLine($"Maks. liczba kontenerów: {MaxLiczbaKontenerow}");
        Console.WriteLine($"Maks. obciążenie: {MaxObciazenie} ton");
        
        double sum = 0;
        foreach (var k in Kontenery)
        {
            sum += k.MasaLadunku + k.WagaWlasnaKontenera;
        }

        Console.WriteLine($"- Całkowita masa: {sum} kg");
    }
}



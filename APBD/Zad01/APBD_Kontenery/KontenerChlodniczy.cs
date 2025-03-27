namespace APBD_Kontenery;

public class KontenerChlodniczy : Kontener, IHazardNotifier
{
    
    private string? RodzajProduktu { get; set; } 
    private double TemperaturaWKontenerze {get; set;}
    
    public KontenerChlodniczy(double masaLadunku, int wysokosc, int wagaWlasnaKontenera, int glebokosc, double maxLadownoscKontenera, string rodzajProduktu, double temperaturaWKontenerze) : base("C", masaLadunku, wysokosc, wagaWlasnaKontenera, glebokosc, maxLadownoscKontenera)
    {
        RodzajProduktu = null;
        TemperaturaWKontenerze = temperaturaWKontenerze;
    }

//Slownik przykladowych produktów i temperatur    
    Dictionary<string,double> produkty = new Dictionary<string, double>{
    {"Bananas",13.3},
    {"Chocolate",18},
    {"Fish",2},
    {"Meat",-15},
    {"Ice cream",-18},
    {"Frozen pizza",-30},
    {"Cheese",7.2},
    {"Sausages",5},
    {"Butter",20.5},
    {"Eggs",19}
                    };

    public void NotifyHazard()
    {
        Console.WriteLine($"Niebezpieczna sytuacja {NumerSeryjny}");
    }
    
    public void Zaladuj(string produkt,double ciezar)
    {
        if (!produkty.ContainsKey(produkt))
        {
            throw new NieprawidlowyProduktException($"Nie ma takiego produktu {produkt}");
        }
        
        double temperaturaDlaProduktu = produkty[produkt];
        if (TemperaturaWKontenerze < temperaturaDlaProduktu)
        {
            throw new NieprawidlowaTemperaturaException(
                $"Zla temperatura dla produktu {produkt} wymagana temperatura to {temperaturaDlaProduktu}");
        }

        if (RodzajProduktu == null)
        {
            RodzajProduktu = produkt;
        }else if (RodzajProduktu != produkt)
        {
            throw new NieprawidlowyProduktException("Ten produkt nie moze byc juz w tym kontenerze");
        }

        
        if (ciezar > MaxLadownoscKontenera)
        {
            NotifyHazard();
            throw new OverflowException("Przekroczono ładowność kontenera");
        }

        MasaLadunku += (int)ciezar;
        Console.WriteLine($"Kontener {NumerSeryjny} załadowany {MasaLadunku}");

    }
    
}
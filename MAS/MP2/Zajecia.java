package MAS.MP2;

import java.util.ArrayList;
import java.util.List;

public class Zajecia {

    private String nazwa;
    private Trener trener;
    //Lista dla asocjacji z atrybutem
    private List<Zapis> zapisy = new ArrayList<>();

    public Zajecia(String nazwa) {
        this.nazwa = nazwa;
    }

//Kwalifikowana
    public void dodajTrenera(Trener trener){
        if(this.trener!=trener) {
            this.trener = trener;

            //Połączenie zwrotne
            trener.dodajZajeciaKwalifikacja(this);
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public Trener getTrener() {
        return trener;
    }

    @Override
    public String toString() {
        return "Zajecia" +
                "\n\tNazwa: " + nazwa;
    }

//Z atrybutem

    public void dodajZapis(Zapis zapis){
        if(!zapisy.contains(zapis)) {
            zapisy.add(zapis);
        }
    }

    public void pokazZapisyNaZajecia() {
        System.out.println("Zajęcia: " + nazwa +
                        "\n\tZapisy:");

        for (Zapis zapis : zapisy) {
            System.out.println("-" + zapis);
        }
    }
}
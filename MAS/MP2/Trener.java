package MAS.MP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Trener {

    private String imie;
    private String rodzajTreningu;
    //Lista dla asocjacji zwykłej
    private List<Klient> klienci = new ArrayList<>();
    //Mapa dla asocjacji kwalifikowanej
    private Map<String,Zajecia> zajeciaKwalifikacja = new TreeMap<>();

    public Trener(String rodzajTreningu, String imie) {
        this.rodzajTreningu = rodzajTreningu;
        this.imie = imie;
    }

//Asocjacja zwykła=============================================
    public void dodajKlienta(Klient klient){
        if(!klienci.contains(klient)) {
            klienci.add(klient);


            //Połączenie zwrotne
            klient.dodajTrenera(this);
        }
    }

    public void klientTrenera(){
        System.out.println("Trener: " + imie +
                "\n\tTrenuje klienta:" + klienci);
    }

    public List<Klient> getKlienci() {
        return new ArrayList<>(klienci);
    }

    @Override
    public String toString() {
        return "Trener:" +
                "\n\tRodzajTreningu: " + rodzajTreningu;
    }
//=============================================================
//Asocjacja kwalifikowana======================================

    public void dodajZajeciaKwalifikacja(Zajecia noweZajecia){

        if(!zajeciaKwalifikacja.containsKey(noweZajecia.getNazwa())){
            zajeciaKwalifikacja.put(noweZajecia.getNazwa(), noweZajecia);

            //Połączenie zwrotne
            noweZajecia.dodajTrenera(this);
        }
    }

    public Zajecia znajdzZajeciaKwalifikacja(String nazwa) throws Exception {
        if (!zajeciaKwalifikacja.containsKey(nazwa)) {
            throw new Exception("Nie znaleziono zajęć o nazwie: " + nazwa);
        }

        return zajeciaKwalifikacja.get(nazwa);
    }

    public void pokazZajeciaKwalifikacja() {
        System.out.println("Trener: " + imie + ", prowadzi zajęcia: " );
        for (Zajecia zajecia : zajeciaKwalifikacja.values()) {
            System.out.println("-" + zajecia);
        }
    }

}

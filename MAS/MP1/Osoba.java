package MAS.MP1;

import java.io.Serializable;
import java.time.LocalDate;

public class Osoba implements Serializable {

    private String imie;
    private String nazwisko;
    private LocalDate dataUrodzenia;
    //Atrybut złożony
    private Adres adres;

    public Osoba(String imie, String nazwisko, LocalDate dataUrodzenia, Adres adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.adres = adres;
    }

    //Atrybut pochodny
    public int getWiek(){
        return LocalDate.now().getYear() - this.dataUrodzenia.getYear();
    }

    public void wypiszDane(){
        System.out.println("Dane osobowe" + "\n" +
                "Imie: " + imie + "\n" +
                "Nazwisko: " + nazwisko + "\n" +
                "Data urodzenia: " + dataUrodzenia + "\n" +
                "Wiek: " + getWiek() + "\n" +
                "Adres: " + adres);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}

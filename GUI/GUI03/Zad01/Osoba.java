package PJA.GUI.GUI03.Zad01;

import java.io.Serializable;

public class Osoba implements Serializable {
    private String imie;
    private String nazwisko;
    private long pesel;
    private String dataUrodzenia;
    private String adresZamieszkania;

    public Osoba(String imie, String nazwisko, long pesel, String dataUrodzenia, String adresZamieszkania) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.adresZamieszkania = adresZamieszkania;
    }
}

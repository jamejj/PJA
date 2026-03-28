package MAS.MP1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Klient extends Osoba implements Serializable {

    private int id;
    private static int counter = 0;
    private LocalDate dataDolaczenia;
    private String rodzajKarnetu;
    private static List<Klient> ekstensja = new ArrayList<>();

    public Klient(String imie, String nazwisko, LocalDate dataUrodzenia, Adres adres, LocalDate dataDolaczenia, String rodzajKarnetu) {
        super(imie, nazwisko, dataUrodzenia, adres);
        this.dataDolaczenia = dataDolaczenia;
        this.rodzajKarnetu = rodzajKarnetu;
        this.id = counter++;
        dodajDoEkstensji(this);
    }

    @Override
    public void wypiszDane() {
        super.wypiszDane();
        System.out.println("\tDane klienta" + "\n" +
                "\tID: " + id + "\n" +
                "\tData dołączenia: " + dataDolaczenia + "\n" +
                "\tRodzaj karnetu: " + rodzajKarnetu + "\n" );

    }

    public static void dodajDoEkstensji(Klient klient) {
        ekstensja.add(klient);
    }
    public static List<Klient> getEkstensja() {
        return ekstensja;
    }

    public static void wypiszEkstensje(){
        for (Klient klient : ekstensja) {
            klient.wypiszDane();
        }
    }

    public static void wyczyscEkstensje(){
        ekstensja.clear();
    }

}


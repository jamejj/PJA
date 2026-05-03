package MAS.MP3.wielodziedziczenie;

public class Recepcjonista {

    private String imie;
    private String nazwisko;
    private double pensjaMiesieczna;
    private int iloscZmian;
    private double dodatekZaZmiane;

    public Recepcjonista(String imie, String nazwisko,
                         double pensjaMiesieczna, int iloscZmian, double dodatekZaZmiane) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensjaMiesieczna = pensjaMiesieczna;
        this.iloscZmian = iloscZmian;
        this.dodatekZaZmiane = dodatekZaZmiane;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getPensjaMiesieczna() {
        return pensjaMiesieczna;
    }

    public int getIloscZmian() {
        return iloscZmian;
    }

    public double getDodatekZaZmiane() {
        return dodatekZaZmiane;
    }

    public double obliczMiesieczneRozliczenie() {
        return pensjaMiesieczna + (iloscZmian * dodatekZaZmiane);
    }

    public String opisRoli() {
        return "Recepcjonista: " + imie + " " + nazwisko
                + "\n\tliczba zmian: " + iloscZmian;
    }
}
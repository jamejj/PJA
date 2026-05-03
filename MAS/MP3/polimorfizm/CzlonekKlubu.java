package MAS.MP3.polimorfizm;

public abstract class CzlonekKlubu {

    private String imie;
    private String nazwisko;

    public CzlonekKlubu(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public abstract double obliczMiesieczneRozliczenie();

    public abstract String opisRoli();

    @Override
    public String toString() {
        return imie + " " + nazwisko
                + "\nRola: " + opisRoli()
                + "\nRozliczenie miesięczne: " + obliczMiesieczneRozliczenie() + " zł";
    }
}
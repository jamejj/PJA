package MAS.MP3.polimorfizm;

public class Klient extends CzlonekKlubu {

    private static int licznikKarnetow = 1;

    private int numerKarnetu;
    private double miesiecznaOplata;
    private double znizkaProcent;

    public Klient(String imie, String nazwisko, double miesiecznaOplata, double znizkaProcent) {
        super(imie, nazwisko);
        this.numerKarnetu = licznikKarnetow++;
        this.miesiecznaOplata = miesiecznaOplata;
        this.znizkaProcent = znizkaProcent;
    }

    public int getNumerKarnetu() {
        return numerKarnetu;
    }

    @Override
    public double obliczMiesieczneRozliczenie() {
        return miesiecznaOplata - (miesiecznaOplata * znizkaProcent / 100);
    }

    @Override
    public String opisRoli() {
        return "Klient " + getImie() + " numer karnetu: " + numerKarnetu;
    }
}
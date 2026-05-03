package MAS.MP3.polimorfizm;

public class Trener extends CzlonekKlubu {

    private double stawkaGodzinowa;
    private int iloscGodzin;
    private double premiaZaPodopiecznego;
    private int liczbaPodopiecznych;

    public Trener(String imie, String nazwisko, double stawkaGodzinowa, int iloscGodzin,
                  double premiaZaPodopiecznego, int liczbaPodopiecznych) {
        super(imie, nazwisko);
        this.stawkaGodzinowa = stawkaGodzinowa;
        this.iloscGodzin = iloscGodzin;
        this.premiaZaPodopiecznego = premiaZaPodopiecznego;
        this.liczbaPodopiecznych = liczbaPodopiecznych;
    }

    @Override
    public double obliczMiesieczneRozliczenie() {
        return (stawkaGodzinowa * iloscGodzin) + (premiaZaPodopiecznego * liczbaPodopiecznych);
    }

    @Override
    public String opisRoli() {
        return "Trener " + getImie() + " liczba godzin: " + iloscGodzin + ", podopieczni: " + liczbaPodopiecznych;
    }
}
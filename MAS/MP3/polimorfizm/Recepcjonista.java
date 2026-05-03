package MAS.MP3.polimorfizm;

public class Recepcjonista extends CzlonekKlubu {

    private double pensjaPodstawowa;
    private int liczbaZmianNocnych;
    private int dodatekZaZmiane;


    public Recepcjonista(String imie, String nazwisko, double pensjaPodstawowa,
                         int liczbaZmianNocnych, int dodatekZaZmiane) {
        super(imie, nazwisko);
        this.pensjaPodstawowa = pensjaPodstawowa;
        this.liczbaZmianNocnych = liczbaZmianNocnych;
        this.dodatekZaZmiane = dodatekZaZmiane;
    }

    @Override
    public double obliczMiesieczneRozliczenie() {
        return pensjaPodstawowa + (liczbaZmianNocnych * dodatekZaZmiane);
    }

    @Override
    public String opisRoli() {
        return "Recepcjonista " + getImie() + " zmiany nocne: " + liczbaZmianNocnych;
    }
}
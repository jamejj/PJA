package MAS.MP3.polimorfizm;

public class Stazysta extends CzlonekKlubu {

    private String opiekunStazu;
    private int liczbaGodzinStazu;
    private double stawkaStazowa;

    public Stazysta(String imie, String nazwisko, String opiekunStazu,
                    int liczbaGodzinStazu, double stawkaStazowa) {
        super(imie, nazwisko);
        this.opiekunStazu = opiekunStazu;
        this.liczbaGodzinStazu = liczbaGodzinStazu;
        this.stawkaStazowa = stawkaStazowa;
    }

    @Override
    public double obliczMiesieczneRozliczenie() {
        return liczbaGodzinStazu * stawkaStazowa;
    }

    @Override
    public String opisRoli() {
        return "Stażysta " + getImie() + " opiekun stażu: " + opiekunStazu;
    }
}
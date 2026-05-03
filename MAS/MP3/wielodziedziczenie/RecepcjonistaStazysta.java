package MAS.MP3.wielodziedziczenie;

public class RecepcjonistaStazysta extends Recepcjonista implements IStazysta {

    private String opiekunStazu;
    private int liczbaGodzinStazu;
    private double stawkaStazowa;
    private String zakresObowiazkow;

    public RecepcjonistaStazysta(String imie, String nazwisko, double pensjaMiesieczna, int iloscZmian, double dodatekZaZmiane,
                                 String opiekunStazu, int liczbaGodzinStazu, double stawkaStazowa, String zakresObowiazkow) {
        super(imie, nazwisko, pensjaMiesieczna, iloscZmian, dodatekZaZmiane);
        this.opiekunStazu = opiekunStazu;
        this.liczbaGodzinStazu = liczbaGodzinStazu;
        this.stawkaStazowa = stawkaStazowa;
        this.zakresObowiazkow = zakresObowiazkow;
    }

    public String getZakresObowiazkow() {
        return zakresObowiazkow;
    }

    @Override
    public String getOpiekunStazu() {
        return opiekunStazu;
    }

    @Override
    public int getLiczbaGodzinStazu() {
        return liczbaGodzinStazu;
    }

    @Override
    public double getStawkaStazowa() {
        return stawkaStazowa;
    }

    @Override
    public double obliczRozliczenieStazysty() {
        return liczbaGodzinStazu * stawkaStazowa;
    }

    @Override
    public String opisStazu() {
        return "Stażysta" +
                "\n\topiekun stażu: " + opiekunStazu
                + "\n\tliczba godzin stażu: " + liczbaGodzinStazu;
    }

    @Override
    public double obliczMiesieczneRozliczenie() {
        return super.obliczMiesieczneRozliczenie() + obliczRozliczenieStazysty();
    }


    @Override
    public String opisRoli() {
        return "Recepcjonista-stażysta"
                + "\n" + super.opisRoli()
                + "\n" + opisStazu()
                + "\nZakres obowiązków: " + zakresObowiazkow;
    }
}
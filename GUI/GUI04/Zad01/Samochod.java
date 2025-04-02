package GUI.GUI04.Zad01;

public class Samochod {

    public enum Marka{

        SKODA,
        MAZDA,
        BMW,
        VOLVO
    }

    private String nrRejestracyjny;

    public Marka marka;

    public Samochod(String nrRejestracyjny, Marka marka) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.marka = marka;
    }

    public Marka getMarka() {
        return marka;
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    @Override
    public String toString() {
        return "Samochod " + marka + " numer rejestracyjny: " + nrRejestracyjny;

    }
}
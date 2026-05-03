package MAS.MP3.wieloaspektowe;

public class CzlonekKlubu {

    private String imie;
    private String nazwisko;
    private Rola rola;
    private StatusCzlonka status;

    public CzlonekKlubu(String imie, String nazwisko, Rola rola, StatusCzlonka status) {
        if (rola == null) {
            throw new IllegalArgumentException("Rola nie może być pusta.");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status nie może być pusty.");
        }
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rola = rola;
        this.status = status;
    }

    public Rola getRola() {
        return rola;
    }

    public StatusCzlonka getStatus() {
        return status;
    }

    public boolean czyAktywny() {
        return status == StatusCzlonka.AKTYWNY;
    }

    public boolean czyZawieszony() {
        return status == StatusCzlonka.ZAWIESZONY;
    }

    @Override
    public String toString() {
        return "CzlonekKlubu:" +
                "\n\tImie: " + imie +
                "\n\tNazwisko: " + nazwisko +
                "\n\tRola: " + rola +
                "\n\tStatus: " + status ;
    }
}
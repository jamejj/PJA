package MAS.MP3.dynamiczne;

public class Trener {

    private String imie;
    private String nazwisko;
    private TypTrenera typTrenera;

    private int liczbaPodopiecznych;
    private int liczbaGrup;

    public Trener(String imie, String nazwisko, TypTrenera typTrenera) {
        if (typTrenera == null) {
            throw new IllegalArgumentException("Typ trenera nie może być pusty.");
        }

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.typTrenera = typTrenera;
    }

    public void zmienNaPersonalnego(int liczbaPodopiecznych) {
        this.typTrenera = TypTrenera.PERSONALNY;
        this.liczbaPodopiecznych = liczbaPodopiecznych;
        this.liczbaGrup = 0;
    }

    public void zmienNaGrupowego(int liczbaGrup) {
        this.typTrenera = TypTrenera.GRUPOWY;
        this.liczbaGrup = liczbaGrup;
        this.liczbaPodopiecznych = 0;
    }

    public String opisSpecjalizacji() {
        if (typTrenera == TypTrenera.PERSONALNY) {
            return "Trener personalny, liczba podopiecznych: " + liczbaPodopiecznych;
        }
        return "Trener grupowy, liczba grup: " + liczbaGrup;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko
                + "\n\tTyp trenera: " + typTrenera
                + "\n\t" + opisSpecjalizacji();
    }
}
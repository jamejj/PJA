package MAS.MP1;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Trener extends Osoba{

    private int id;
    private static int counter = 0;
    private String pseudonim;
    private double stawkaGodzinowa;
    //Atrybut klasowy
    private static final double maxStawkaGodzinowa = 500.00;
    //Atrybut opcjonalny
    private Optional<Double> premia = Optional.empty();
    //Atrybut powtarzalny
    private List<String> specjalizacja;


    //Konstruktor dla obiektu z atrybutem opcojalnym
    public Trener(String imie, String nazwisko, LocalDate dataUrodzenia, Adres adres, String pseudonim,
                  double stawkaGodzinowa, Optional<Double> premia, List<String> specjalizacja) {
        super(imie, nazwisko, dataUrodzenia, adres);
        this.id = counter++;
        this.pseudonim = pseudonim;
        setStawkaGodzinowa(stawkaGodzinowa);
        this.premia = premia;
        this.specjalizacja = specjalizacja;

    }

    //Konstruktor dla obiektu bez atrybutu opcjonalnego
    public Trener(String imie, String nazwisko, LocalDate dataUrodzenia, Adres adres, String pseudonim,
                  double stawkaGodzinowa, List<String> specjalizacja) {
        super(imie, nazwisko, dataUrodzenia, adres);
        this.id = counter++;
        this.pseudonim = pseudonim;
        setStawkaGodzinowa(stawkaGodzinowa);
        this.specjalizacja = specjalizacja;
    }

    public double getStawkaGodzinowa() {
        return stawkaGodzinowa;
    }

    public void setStawkaGodzinowa(double stawkaGodzinowa) {
        if (stawkaGodzinowa < 0 )
            throw new IllegalArgumentException("Stawka godzinowa nie może być mniejsza od 0 zł ");
        else if( stawkaGodzinowa > maxStawkaGodzinowa )
            throw new IllegalArgumentException("Stawka godzinowa nie może być wyżssza od " + maxStawkaGodzinowa + " zł");
        else
            this.stawkaGodzinowa = stawkaGodzinowa;
    }

    //Przesłonięcie
    @Override
    public void wypiszDane() {
        super.wypiszDane();
        System.out.println("\tDane trenerskie" + "\n" +
                "\tID: " + id + "\n" +
                "\tPseudonim: " + pseudonim + "\n" +
                "\tStawka godzinowa: " + stawkaGodzinowa + "\n" +
                "\tSpecjalizacja: " + specjalizacja);
    }

    public double obliczKosztTreningu(){
        return stawkaGodzinowa;
    }

    //Przeciążenie
    public double obliczKosztTreningu(double czasTreningu){
        return stawkaGodzinowa*czasTreningu;
    }

    //Metoda klasowa
    public static void pokazMaksymalnaStawke(){
        System.out.println("Maksymalna stawka godzinowa trenera wynosi: " + maxStawkaGodzinowa);
    }
}

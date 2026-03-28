package MAS.MP1;

import java.io.Serializable;
import java.util.Optional;

public class Adres implements Serializable {

    private String miasto;
    private String ulica;
    private String numerDomu;
    private String numerMieszkania;
    private String kodPocztowy;

    public Adres(String miasto, String ulica, String numerDomu, String numerMieszkania, String kodPocztowy) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s",miasto, ulica, numerDomu, numerMieszkania, kodPocztowy);
    }
}

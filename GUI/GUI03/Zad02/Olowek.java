package PJA.GUI.GUI03.Zad02;

import java.io.Serializable;

public class Olowek implements Serializable {

    private boolean czyZGumka;
    private String twardosc;

    public Olowek(boolean czyZGumka, String twardosc) {
        this.czyZGumka = czyZGumka;
        this.twardosc = twardosc;
    }

    @Override
    public String toString() {
        return "Olowek";
    }
}

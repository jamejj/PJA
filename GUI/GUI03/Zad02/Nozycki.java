package PJA.GUI.GUI03.Zad02;

import java.io.Serializable;

public class Nozycki implements Serializable {

    private boolean czyOstre;
    private String kolor;

    public Nozycki(boolean czyOstre, String kolor) {
        this.czyOstre = czyOstre;
        this.kolor = kolor;
    }

    @Override
    public String toString() {
        return "Nozycki";
    }
}


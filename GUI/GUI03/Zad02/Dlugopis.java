package PJA.GUI.GUI03.Zad02;

import java.io.Serializable;

public class Dlugopis implements Serializable {

    private boolean czyZmazywalny;
    private String kolor;

    public Dlugopis(boolean czyZmazywalny, String kolor) {
        this.czyZmazywalny = czyZmazywalny;
        this.kolor = kolor;
    }

    @Override
    public String toString() {
        return "Dlugopis";
    }
}

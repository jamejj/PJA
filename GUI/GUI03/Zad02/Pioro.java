package PJA.GUI.GUI03.Zad02;

import java.io.Serializable;

public class Pioro implements Serializable {

    private boolean naWklady;
    private int cena;

    public Pioro(boolean naWklady, int cena) {
        this.naWklady = naWklady;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Pioro";
    }
}

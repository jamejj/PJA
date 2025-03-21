package PJA.GUI.GUI03.Zad02;

import java.io.Serializable;
import java.util.ArrayList;

public class Piornik implements Serializable {

    ArrayList<Object> piornik;

    public Piornik() {
        this.piornik = new ArrayList<>();
    }

    public void addPiornik(Object o) {
        this.piornik.add(o);
    }

    @Override
    public String toString() {
        return "W piórniku" + piornik;
    }
}

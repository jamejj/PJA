package PJA.GUI.GUI03.Zad02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {


        Dlugopis dlugopis = new Dlugopis(true,"niebieski");
        Pioro pioro = new Pioro(true,255);
        Olowek olowek = new Olowek(false,"H5");
        Nozycki nozycki = new Nozycki(false,"zielone");
        Piornik piornik = new Piornik();

        piornik.addPiornik(dlugopis);
        piornik.addPiornik(pioro);
        piornik.addPiornik(olowek);
        piornik.addPiornik(nozycki);

        System.out.println(piornik);

        writeByObject(piornik);
    }

    public static void writeByObject(Piornik piornik) throws IOException {

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("SciezkaDoPliku"));
            oos.writeObject(piornik);
        } finally {
            if (oos != null) {
                oos.close();
            }
        }

    }
}


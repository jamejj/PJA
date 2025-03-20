package PJA.GUI.GUI02.Zad01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Kwadrat kwadrat1 = new Kwadrat("niebieski",5);
        Kwadrat kwadrat2 = new Kwadrat("czerwony",5);
        Kolo kolo1 = new Kolo("żółte",5);
        Kolo kolo2 = new Kolo("brązowe",5);

        ArrayList<Figura> figury = new ArrayList<>();
        figury.add(kwadrat1);
        figury.add(kolo1);
        figury.add(kwadrat2);

        System.out.println(figury.toString());

    }
}
package MAS.MP1;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //Obiekt klasy Osoba
        Osoba osoba = new Osoba("Kamil", "Zdun",
                LocalDate.of(2003,2,8),
                new Adres("Warszawa","Mazowiecka","13", "14","00-999"));

        osoba.wypiszDane();

        System.out.println();

        Trener trener1 = new Trener("Damian","Wąsik",
                LocalDate.of(2000,9,24),
                new Adres("Warszawa", "Wiatraczna", "11A","Brak","77-888"),
                1, "DW", 160, Optional.of(120.0), List.of("Łydki","Barki"));

        trener1.wypiszDane();

        System.out.println();

        Trener trener2 = new Trener("Adrian","Puchacki",
                LocalDate.of(1999,1,13),
                new Adres("Warszawa", "Grochowska", "67","16","04-398"),
                2, "Detonator", 100, List.of("MMA","Ławka"));

        trener2.wypiszDane();
        System.out.println();
        System.out.println("Koszt treningu wyniesie: " + trener2.obliczKosztTreningu(1.5) + " zł");

        System.out.println();
        Trener.pokazMaksymalnaStawke();
    }
}

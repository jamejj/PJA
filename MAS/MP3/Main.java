package MAS.MP3;

import MAS.MP3.polimorfizm.CzlonekKlubu;
import MAS.MP3.polimorfizm.Klient;
import MAS.MP3.polimorfizm.Recepcjonista;
import MAS.MP3.polimorfizm.Stazysta;
import MAS.MP3.polimorfizm.Trener;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Polimorfizm===========================================================================================================

        List<CzlonekKlubu> osoby = new ArrayList<>();

        osoby.add(new Klient("Damian", "Wąsik", 120.00, 10));
        osoby.add(new Trener("Kamil", "Zdun", 90.00, 40, 50.00, 6));
        osoby.add(new Recepcjonista("Jagna", "Nowak", 4200.00, 4, 100));
        osoby.add(new Stazysta("Marek", "Kowalski", "Anna Nowak", 80, 20.00));

        for (CzlonekKlubu osoba : osoby) {
            System.out.println(osoba);
            System.out.println("=======================");
        }

        // Overlapping===========================================================================================================

        MAS.MP3.overlapping.CzlonekKlubu czlonek =
                new MAS.MP3.overlapping.CzlonekKlubu(
                        "Michał",
                        "Głuś",
                        EnumSet.of(MAS.MP3.overlapping.Rola.KLIENT)
                );

        System.out.println(czlonek.czyMaRole(MAS.MP3.overlapping.Rola.STAZYSTA));
        System.out.println(czlonek.getRole());

        czlonek.dodajRole(MAS.MP3.overlapping.Rola.STAZYSTA);

        System.out.println(czlonek.getRole());
        System.out.println("=======================");

        // Wielodziedziczenie====================================================================================================

        MAS.MP3.wielodziedziczenie.RecepcjonistaStazysta osobaWielodziedziczenie =
                new MAS.MP3.wielodziedziczenie.RecepcjonistaStazysta(
                        "Ola",
                        "Kowalska",
                        3200,
                        30,
                        50,
                        "Anna Nowak",
                        240,
                        15,
                        "Obsługa recepcji"
                );

        System.out.println(osobaWielodziedziczenie.opisStazu());
        System.out.println(osobaWielodziedziczenie.obliczRozliczenieStazysty());
        System.out.println();
        System.out.println(osobaWielodziedziczenie.opisRoli());
        System.out.println("=======================");

        // Wieloaspektowe====================================================================================================

        MAS.MP3.wieloaspektowe.CzlonekKlubu osobaWieloaspektowa =
                new MAS.MP3.wieloaspektowe.CzlonekKlubu(
                        "Kamil",
                        "Zdun",
                        MAS.MP3.wieloaspektowe.Rola.TRENER,
                        MAS.MP3.wieloaspektowe.StatusCzlonka.ZAWIESZONY
                );

        System.out.println(osobaWieloaspektowa);
        System.out.println("Czy aktywny? " + osobaWieloaspektowa.czyAktywny());
        System.out.println("=======================");

        // Dynamiczne============================================================================================================

        MAS.MP3.dynamiczne.Trener trenerDynamiczny =
                new MAS.MP3.dynamiczne.Trener(
                        "Kamil",
                        "Zdun",
                        MAS.MP3.dynamiczne.TypTrenera.PERSONALNY
                );

        trenerDynamiczny.zmienNaPersonalnego(10);
        System.out.println(trenerDynamiczny);

        System.out.println();

        trenerDynamiczny.zmienNaGrupowego(3);
        System.out.println(trenerDynamiczny);
    }
}
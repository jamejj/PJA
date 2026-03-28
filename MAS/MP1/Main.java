package MAS.MP1;

import java.io.*;
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
                "DW", 160, Optional.of(120.0), List.of("Łydki","Barki"));

        trener1.wypiszDane();

        System.out.println();

        Trener trener2 = new Trener("Adrian","Puchacki",
                LocalDate.of(1999,1,13),
                new Adres("Warszawa", "Grochowska", "67","16","04-398"),
                "Detonator", 100, List.of("MMA","Ławka"));

        trener2.wypiszDane();
        System.out.println();
        System.out.println("Koszt treningu wyniesie: " + trener2.obliczKosztTreningu(1.5) + " zł");

        System.out.println();
        Trener.pokazMaksymalnaStawke();

        System.out.println();

        Klient klient1 = new Klient("Michał","Głuś",
                LocalDate.of(1998,7,8),
                new Adres("Dawidy","Rdstu", "12B","Brak","00-000"),
                LocalDate.now().minusDays(25),"Standard");

        klient1.wypiszDane();


//======================================================================================================================
        Klient klient2 = new Klient("Maciej","Klimek",
                LocalDate.of(1999,1,13),
                new Adres("Warszawa", "Marymoncka", "120","5","68-677"),
                LocalDate.now().minusDays(100),"VIP");

        Klient klient3 = new Klient("Sebastian","Bąk",
                LocalDate.of(2001,4,6),
                new Adres("Warszawa", "Krupnicza", "3","2","51-322"),
                LocalDate.now().minusDays(547),"Minimum");


        System.out.println(Klient.getEkstensja());
        System.out.println();
        Klient.wypiszEkstensje();

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try{
            serializujDoPliku(Klient.getEkstensja());
            Klient.wyczyscEkstensje();
            System.out.println("Odczyt z serializacji");
            odczytZSerializacji("ekstensja.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("===============================");

        Klient.wypiszEkstensje();

        System.out.println("===============================");


    }

    public static void serializujDoPliku(List<Klient> ekstensja) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ekstensja.bin"));

        for(Klient klient : ekstensja)
            oos.writeObject(klient);

        oos.flush();
        oos.close();

    }

    public static void odczytZSerializacji(String path) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        Klient klient;
        while(true){
            try{
                klient = (Klient) ois.readObject();
                Klient.dodajDoEkstensji(klient);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (EOFException e){
                System.out.println("Koniec pliku");
                break;
            }
        }
        ois.close();
    }
}

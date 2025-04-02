package GUI.GUI04.Zad01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Osoba kowalski = new Osoba("Jan", "Kowalski");
        Osoba nowak = new Osoba("Adam", "Nowak");
        Osoba krawczyk = new Osoba("Bartosz", "Krawczyk");
        Osoba heniek = new Osoba("Kierownik", "Heniek");
        Samochod skoda1 = new Samochod("WA00001", Samochod.Marka.SKODA);
        Samochod skoda2 = new Samochod("SC36010", Samochod.Marka.SKODA);
        Samochod mazda1 = new Samochod("WA01234", Samochod.Marka.MAZDA);
        Samochod mazda2 = new Samochod("DW01ASD", Samochod.Marka.MAZDA);
        Samochod bmw = new Samochod("WA12690", Samochod.Marka.BMW);
        Samochod volvo = new Samochod("KR60606", Samochod.Marka.VOLVO);

        Map<Osoba, List<Samochod>> mapaSamochodow = new HashMap<>();

        mapaSamochodow.put(kowalski, List.of(skoda1,bmw));
        mapaSamochodow.put(nowak, List.of(mazda2));
        mapaSamochodow.put(krawczyk, List.of(volvo,mazda1,skoda2));
        mapaSamochodow.put(heniek, List.of());

        for(Map.Entry<Osoba,List<Samochod>> entry : mapaSamochodow.entrySet()){
            for(Samochod samochod1 : entry.getValue()){
                if (samochod1.getNrRejestracyjny().startsWith("WA")){
                    System.out.println(samochod1);
                    System.out.println("==============================");
                }
                System.out.println(entry.getKey().getImie() + " " + entry.getKey().getNazwisko() + " posiada " + entry.getValue().size() + " pojazdy");
            }
        }

        System.out.println();
        System.out.println(mapaSamochodow.get(nowak).get(0));

    }
}

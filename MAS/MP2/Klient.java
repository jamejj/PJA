package MAS.MP2;

import java.util.ArrayList;
import java.util.List;

public class Klient {

    private String imie;
    private String nazwisko;
    //Lista dla asocjacji
    private List<Trener> trenerzy =  new ArrayList<>();
    //Lista dla kompozycji
    private List<Progres> progresy = new ArrayList<>();
    //Lista dla asocjacji z atrybutem
    private List<Zapis> zapisy = new ArrayList<>();

    public Klient(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

//Asocjacja zwykła=============================================
    public void dodajTrenera(Trener trener){
        if(!trenerzy.contains(trener)) {
            trenerzy.add(trener);

            //Połączenie zwrotne
            trener.dodajKlienta(this);
        }
    }

    public List<Trener> getTrenerzy() {
        return new ArrayList<>(trenerzy);
    }

    public void trenerKlienta(){
        System.out.println("Klient: " + imie + " " + nazwisko +
                            "\n\tTrenuje z trenerami od treningu" + trenerzy);
    }

//==============================================================
//Kompozycja====================================================


    public Progres dodajProgres(String opis) throws Exception {
        //progresy.clear();
        Progres progres = new Progres(opis);
        progresy.add(progres);
        return progres;
    }

    @Override
    public String toString() {
        return "Klient " + imie + ":" +
                "\n\tImie: " + imie +
                "\n\tNazwisko: " + nazwisko;
    }

    public class Progres{

        private String opis;

        private Progres(String opis) throws Exception {
            if(opis == null || opis.isBlank())
                throw new Exception("Opis nie może być pusty");
            this.opis = opis;

        }

        public Klient getKlient() {
            return Klient.this;
        }

        public void pokazOstatniProgres() {
            Progres ostatni = getKlient().progresy.get(Klient.this.progresy.size() - 1);

            System.out.println("Klient: " + getKlient().imie + " " + getKlient().nazwisko
                    + " ostatni progres: " + ostatni.opis);

        }

        @Override
        public String toString() {
            return "Progres: " + opis;
        }
    }

//==============================================================
//Asocjacja z atrybutem=========================================

    public void dodajZapis(Zapis zapis){
        if(!zapisy.contains(zapis)){
            zapisy.add(zapis);
        }
    }

    public void pokazZapisyKlienta() {
        System.out.println("Klient: " + imie + " " + nazwisko);
        System.out.println("\n\tZapisy:");

        for (Zapis zapis : zapisy) {
            System.out.println("-" + zapis);
        }
    }
}

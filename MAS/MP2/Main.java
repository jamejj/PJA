package MAS.MP2;

public class Main {
    public static void main(String[] args) {

//--Obiekty

    Trener trener1 = new Trener("Siłowy","Mati");
    Trener trener2 = new Trener("Kardio","Michał");

    Klient klient1 = new Klient("Damian","Wąsik");
    Klient klient2 = new Klient("Kamil","Zdun");
    Klient klient3 = new Klient("Andżelika","Bąk");

    Zajecia zajecia1 = new Zajecia("Yoga");
    Zajecia zajecia2 = new Zajecia("Rozciąganie");
    Zajecia zajecia3 = new Zajecia("Yoga");

    Zapis zapis1 = new Zapis("03-04-2026","Zakończone",80,klient2,zajecia2);


//--Asocjacja zwykła

    trener1.dodajKlienta(klient1);
    klient1.trenerKlienta();
    trener1.klientTrenera();


//--Kompozycja

        try{
            Klient.Progres progres = klient1.dodajProgres("Nowy max bp: 100kg");
            Klient.Progres progres1 = klient3.dodajProgres("Nowy max przysiad: 100kg");
            klient1.dodajProgres("Nowy max df: 200kg");
            System.out.println("======================================================");
            System.out.println(progres.getKlient());
            System.out.println("======================================================");
            progres.pokazOstatniProgres();
            progres1.pokazOstatniProgres();
        }catch (Exception e){
            e.printStackTrace();
        }

//--Kwalifikacja
        System.out.println("======================================================");

        trener2.dodajZajeciaKwalifikacja(zajecia1);
        trener2.dodajZajeciaKwalifikacja(zajecia2);
        trener2.dodajZajeciaKwalifikacja(zajecia3); //nie doda bo już są te zajęcia

        try {
            //trener2.znajdzZajeciaKwalifikacja("Crossfit");
            trener2.pokazZajeciaKwalifikacja();
        }catch (Exception e){
            e.printStackTrace();
        }

//--Asocjacja z atrybutem
        //Tworzenie zapisów w Obiektach na górze
        System.out.println("======================================================");
        klient2.pokazZapisyKlienta();
        System.out.println("======================================================");
        zajecia2.pokazZapisyNaZajecia();

    }
}

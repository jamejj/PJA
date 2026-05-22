package MAS.MP4.src.main.java;

import model.*;
import repository.*;
import utility.JpaUtility;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SilowniaRepository silowniaRepo = new SilowniaRepository();
        TrenerRepository trenerRepo = new TrenerRepository();
        PlanTreningowyRepository planRepo = new PlanTreningowyRepository();
        KlientRepository klientRepo = new KlientRepository();
        PrzypisaniePlanuRepository przypisanieRepo = new PrzypisaniePlanuRepository();

        Adres adres = new Adres("Warszawa", "Mazowiecka", "12", null, "00-000");

        Silownia silownia = Silownia.builder()
                .nazwa("Zdrofit")
                .adres(adres)
                .build();

        silowniaRepo.save(silownia);

        Trener trener = Trener.builder()
                .imie("Kamil")
                .nazwisko("Zdun")
                .email("kamil@gmail.com")
                .telefon("123456789")
                .adres(adres)
                .stawkaGodzinowa(80)
                .silownia(silownia)
                .build();

        trener.getSpecjalizacja().add("Trening silowy");
        trener.getSpecjalizacja().add("Redukcja");

        trenerRepo.save(trener);

        PlanTreningowy plan = PlanTreningowy.builder()
                .nazwa("Plan na mase")
                .opis("Plan treningowy dla poczatkujacych")
                .poziom(PoziomTrudnosci.POCZATKUJACY)
                .build();

        Cwiczenie cw1 = Cwiczenie.builder()
                .nazwa("Wyciskanie sztangi")
                .opis("Klata")
                .serie(4)
                .powtorzenia(10)
                .planTreningowy(plan)
                .build();

        Cwiczenie cw2 = Cwiczenie.builder()
                .nazwa("Przysiady")
                .opis("Nogi")
                .serie(4)
                .powtorzenia(12)
                .planTreningowy(plan)
                .build();

        plan.getCwiczenia().add(cw1);
        plan.getCwiczenia().add(cw2);

        planRepo.save(plan);

        Klient klient = Klient.builder()
                .imie("Damian")
                .nazwisko("Wasik")
                .email("damian@gmail.com")
                .telefon("999999999")
                .adres(adres)
                .numerKlienta("K001")
                .dataRejestracji(LocalDate.now())
                .rodzajKarnetu("Premium")
                .build();

        klient.getCeleTreningowe().add("Masa");
        klient.getCeleTreningowe().add("Sila");

        klientRepo.save(klient);

        PrzypisaniePlanu przypisanie = PrzypisaniePlanu.builder()
                .klient(klient)
                .planTreningowy(plan)
                .dataOd(LocalDate.now())
                .dataDo(LocalDate.now().plusMonths(2))
                .uwagi("Plan przypisany po konsultacji")
                .build();

        przypisanieRepo.save(przypisanie);

        System.out.println("=============== ZAPIS DO BAZY ===============");
        System.out.println("Zapisano silownie, trenera, klienta, plan, cwiczenia i przypisanie planu.");

        System.out.println("\n=============== FIND BY ID ===============");
        Klient znalezionyKlient = klientRepo.findById(klient.getId());

        if (znalezionyKlient != null) {
            System.out.println("Znaleziono klienta: " + znalezionyKlient.getImie() + " " + znalezionyKlient.getNazwisko());
        }

        System.out.println("\n=============== FIND ALL KLIENCI ===============");
        for (Klient k : klientRepo.findAll()) {
            System.out.println(k.getId() + ": " + k.getImie() + " " + k.getNazwisko());
        }

        System.out.println("\n=============== FIND ALL SILOWNIE ===============");
        for (Silownia s : silowniaRepo.findAll()) {
            System.out.println(s.getId() + ": " + s.getNazwa());
        }

        System.out.println("\n=============== FIND ALL TRENERZY ===============");
        for (Trener t : trenerRepo.findAll()) {
            System.out.println(t.getId() + ": " + t.getImie() + " " + t.getNazwisko());
        }

        System.out.println("\n=============== FIND ALL PLANY ===============");
        for (PlanTreningowy p : planRepo.findAll()) {
            System.out.println(p.getId() + ": " + p.getNazwa() + " " + p.getPoziom());
        }

        System.out.println("\n=============== FIND ALL PRZYPISANIA ===============");
        for (PrzypisaniePlanu p : przypisanieRepo.findAll()) {
            System.out.println(p.getId() + ": " + p.getUwagi());
        }

        JpaUtility.close();
    }
}
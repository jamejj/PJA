package PJA.GUI.GUI03.Zad01;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj imię");
        String imie = sc.nextLine();

        System.out.println("Podaj nazwisko");
        String nazwisko = sc.nextLine();

        System.out.println("Podaj PESEL");
        long pesel = sc.nextLong();
        sc.nextLine();

        System.out.println("Podaj date urodzenia");
        String dataUrodzenia = sc.nextLine();

        System.out.println("Podaj adres zamieszkania");
        String adresZamieszkania = sc.nextLine();
        */


//        writeByBuffered(imie,nazwisko,pesel,dataUrodzenia,adresZamieszkania);
//        writeByOutput(imie,nazwisko,pesel,dataUrodzenia,adresZamieszkania);


        Osoba osoba = new Osoba("Jan","Kowalski",12345678910l,"12-12-1985","Mazowiecka 12");

        writeByObject(osoba);



    }

    public static void writeByBuffered(String imie, String nazwisko,long pesel,String dataUrodzenia,String adresZamieszkania) throws IOException {

        BufferedWriter br = null;

        try {
            br = new BufferedWriter(new FileWriter("SciezkaDoPliku"));
            br.write(imie);
            br.newLine();
            br.write(nazwisko);
            br.newLine();
            br.write(String.valueOf(pesel));
            br.newLine();
            br.write(dataUrodzenia);
            br.newLine();
            br.write(adresZamieszkania);

        } finally {
            if (br != null)
                br.close();

        }
    }




        public static void writeByOutput(String imie, String nazwisko,long pesel,String dataUrodzenia,String adresZamieszkania) throws IOException {

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("SciezkaDoPliku");
                fos.write(imie.getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(nazwisko.getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write((int) pesel);
                fos.write(System.lineSeparator().getBytes());
                fos.write(dataUrodzenia.getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(adresZamieszkania.getBytes());
                fos.write(System.lineSeparator().getBytes());


            } finally {
                if (fos != null)
                    fos.close();
            }
        }

        public static void writeByObject(Osoba osoba) throws IOException {

            ObjectOutputStream oos = null;

            try {
                oos = new ObjectOutputStream(new FileOutputStream("SciezkaDoPliku"));
                oos.writeObject(osoba);
            } finally {
             if (oos != null) {
                oos.close();
             }
            }

        }
}


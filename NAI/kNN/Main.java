package kNN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String fileName = "PJA\\NAI\\kNN\\iris.txt";

        ArrayList<IrisData> irisDataArr = new ArrayList<>();
        ArrayList<IrisData> zbiorTreningowy = new ArrayList<>();
        ArrayList<IrisData> zbiorTestowy = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                double sepalLengthInCm = Double.parseDouble(parts[0]);
                double sepalWidthInCm = Double.parseDouble(parts[1]);
                double petalLengthInCm = Double.parseDouble(parts[2]);
                double petalWidthInCm = Double.parseDouble(parts[3]);
                String type = parts[4];

                irisDataArr.add(new IrisData(sepalLengthInCm,sepalWidthInCm,petalLengthInCm,petalWidthInCm,type));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Wyswietlanie zbioru IrisData
//        System.out.println(irisDataArr);
        zbiorTreningowy.addAll(irisDataArr.subList(0, (int)(irisDataArr.size()*0.8)));
        //Wyswietlanie zbioru treningowego
//        System.out.println(zbiorTreningowy);
        System.out.println(zbiorTreningowy.size());
        zbiorTestowy.addAll(irisDataArr.subList((int)(irisDataArr.size()*0.8), irisDataArr.size()));
        //Wyswietlanie zbioru testowego
//        System.out.println(zbiorTestowy);
        System.out.println(zbiorTestowy.size());


        ArrayList<Double> sortTested = new ArrayList<>();

        for (int i = 0; i < zbiorTestowy.size(); i++) {
            IrisData testowy = zbiorTestowy.get(i);
            for (int j = 0; j < zbiorTreningowy.size(); j++) {
                IrisData treningowy = zbiorTreningowy.get(j);

                showString(testowy, treningowy);

                sortTested.add(odlegloscEuklidesowa(testowy,treningowy));
            }
        }

        System.out.println("=========================================================================================");
//        System.out.print(sortTested + "\n");
//        System.out.println("=========================================================================================");
//        Collections.sort(sortTested);
//        System.out.print(sortTested + "\n");
//        System.out.println("=========================================================================================");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj parametr k");
        int k = scanner.nextInt();

        int poprawne = 0;

        for (int i = 0; i < zbiorTestowy.size(); i++) {
            IrisData testowy = zbiorTestowy.get(i);
            ArrayList<IrisData> kNajblizszych = new ArrayList<>(zbiorTreningowy);

            //Po posortowaniu kNajblizszych od 0 to najblizszy sąsiad
            Collections.sort(kNajblizszych, new Comparator<IrisData>() {
                @Override
                public int compare(IrisData o1, IrisData o2) {
                    double odo1 = odlegloscEuklidesowa(testowy, o1);
                    double odo2 = odlegloscEuklidesowa(testowy, o2);
                    return Double.compare(odo1, odo2);
                }
            });
//            System.out.println("Somsiad \uD83D\uDC12" + kNajblizszych + " " + sortTested.get(i));
//            System.out.println("Somsiad \uD83D\uDC12: " + " " + sortTested.get(i));





            ArrayList<String> klasyLista = new ArrayList<>(); //przechowuje k najblizszych sąsiadów
            String przewidzianaKlasa = null;
            int maxIloscKlas = 0; //najczęstsza ilosc wystąpien danej klasy

            for (int j = 0; j < k; j++) {
                double odlegloscEuklidesowa = odlegloscEuklidesowa(testowy, kNajblizszych.get(j));
                System.out.println("Somsiad \uD83D\uDC12 " + (j+1) + ": " + kNajblizszych.get(j).getType() + " " + odlegloscEuklidesowa);

                String klasa = kNajblizszych.get(j).getType();

                int count = Collections.frequency(klasyLista, klasa);

                if (count > maxIloscKlas) {
                    maxIloscKlas = count;
                    przewidzianaKlasa  = klasa;
                }
                klasyLista.add(klasa);

            }

            System.out.print("Irys ze zbioru testowego nr " + (i+1) + " " + testowy.getType() + " -> Przewidziana klasa: " + przewidzianaKlasa + " ");


            if (przewidzianaKlasa.equals(testowy.getType())) {
                poprawne++;

            }
            if (przewidzianaKlasa.equals(testowy.getType())) {
                System.out.println("  \uD83D\uDC4D");
            }else{
                System.out.println("  \uD83D\uDC4E");
            }


        }
        double celnosc = (poprawne * 100) / zbiorTestowy.size();
        System.out.println();
        System.out.println("Celność klasyfikatora: " + celnosc);


    }

    public static double odlegloscEuklidesowa(IrisData zbiorTestowy, IrisData zbiorTreningowy) {
        double sum = 0;

        sum += Math.pow(zbiorTestowy.getSepalLengthInCm() - zbiorTreningowy.getSepalLengthInCm(), 2);
        sum += Math.pow(zbiorTestowy.getSepalWidthInCm() - zbiorTreningowy.getSepalWidthInCm(), 2);
        sum += Math.pow(zbiorTestowy.getPetalLengthInCm() - zbiorTreningowy.getPetalLengthInCm(), 2);
        sum += Math.pow(zbiorTestowy.getPetalWidthInCm() - zbiorTreningowy.getPetalWidthInCm(), 2);

        return Math.sqrt(sum);
    }

    public static void showString(IrisData testowy, IrisData treningowy) {

        System.out.println(
                "Odległość " + testowy.getType() +
                        " o parametrach -> (SL: " + testowy.getSepalLengthInCm() +
                        ", SW : " + testowy.getSepalWidthInCm() +
                        ", PL: " + testowy.getPetalLengthInCm() +
                        ", PW: " + testowy.getPetalWidthInCm() + ") " +
                        " od " +
                        treningowy.getType() +
                        " o parametrach -> (SL: " + treningowy.getSepalLengthInCm() +
                        ", SW : " + treningowy.getSepalWidthInCm() +
                        ", PL: " + treningowy.getPetalLengthInCm() +
                        ", PW: " + treningowy.getPetalWidthInCm() + ") wynosi: " +
                        odlegloscEuklidesowa(testowy, treningowy));
    }


}

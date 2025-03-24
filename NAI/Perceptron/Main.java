package Perceptron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList <IrisData> irisData = new ArrayList<>();
        ArrayList<IrisData> zbiorTreningowy = new ArrayList<>();
        ArrayList<IrisData> zbiorTestowy = new ArrayList<>();

        String fileName = "PJA\\NAI\\Perceptron\\iris.txt";

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while((line = br.readLine())!=null){
                String[] parts = line.split(",");
                double[] cechy = {
                        Double.parseDouble(parts[0]),
                        Double.parseDouble(parts[1]),
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])
                };
                String typ = parts[4];
                boolean czySetosa = typ.equals("Iris-setosa");
                irisData.add(new IrisData(cechy,czySetosa));



            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.shuffle(irisData);

        zbiorTreningowy.addAll(irisData.subList(0, (int)(irisData.size()*0.8)));
        zbiorTestowy.addAll(irisData.subList((int)(irisData.size()*0.8), irisData.size()));

        Perceptron perceptron = new Perceptron(4,0.2,0.1);

        //Trening
        for (int epoka = 0; epoka < 20; epoka++) {
            for (IrisData i : zbiorTreningowy) {
                perceptron.learn(i.getCechy(), i.isCzySetosa() ? 1 : 0);
                System.out.println("Trenuję na: " + (i.isCzySetosa() ? "Iris-setosa" : "Inna"));

            }
        }

        int pop = 0;

        for (IrisData i : zbiorTestowy) {
            int przewidzianaOdp = perceptron.compute(i.getCechy());
            int prawdziwaOdp = i.isCzySetosa() ? 1 : 0;
            System.out.println(i.isCzySetosa() ? 1 : 0);

            boolean dobrzeDopasowana = przewidzianaOdp == prawdziwaOdp;

            if (dobrzeDopasowana) {
                pop++;
            }
            System.out.println("Kwiat testowy -> Przewidziana klasa: " + (przewidzianaOdp == 1 ? "Iris-setosa" : "Inna") +
                    " | Rzeczywista klasa: " + (prawdziwaOdp == 1 ? "Iris-setosa" : "Inna") +
                    (dobrzeDopasowana ? " \uD83D\uDC4D" : " \uD83D\uDC4E")
            );
        }

        double celnosc = (pop * 100.0) / zbiorTestowy.size();
        System.out.println("Celnosc perceptronu -> " + celnosc + "%");


    }
}
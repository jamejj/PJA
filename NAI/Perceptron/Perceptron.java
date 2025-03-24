package Perceptron;

public class Perceptron {

    private int dlugoscWektoraWag;
    private double[] wagi;
    private double prog;
    private double stalaAlfa;

    public Perceptron(int dlugoscWektoraWag, double prog, double stalaAlfa) {
        this.dlugoscWektoraWag = dlugoscWektoraWag;
        this.wagi = new double[dlugoscWektoraWag];
        wagiInit();
        this.prog = prog;
        this.stalaAlfa = stalaAlfa;
    }

    public void wagiInit(){
        for (int i = 0; i < wagi.length; i++) {
            wagi[i] = Math.random();
        }
    }


    public int compute(double[] arg){
        if(arg.length != this.wagi.length)
            throw new ArrayIndexOutOfBoundsException("Różne rozmiary wektora wag i wejsc");

        double sum = 0;
        for (int i = 0; i < wagi.length; i++) {
            sum += arg[i] * wagi[i];
        }
        System.out.println("Obliczona suma: " + sum + ", próg: " + prog);

        return sum >= prog ? 1 : 0;
    }

    public void learn(double[] vecIn, int oczOdp){
        int odp = compute(vecIn);
        int blad = oczOdp - odp;

        if(blad != 0){
            System.out.println("Aktualizuję wagi! Błąd: " + blad);

            for (int i = 0; i < wagi.length; i++) {
                wagi[i] += blad * stalaAlfa * vecIn[i];

            }
            prog += blad * stalaAlfa;

            System.out.println();
//            System.out.println("blad " + blad + " oczekiwana odp " + oczOdp + " odpowiedz perceptrona " + odp);
//            System.out.println(Arrays.toString(wagi));
            System.out.println("Nowy próg: " + prog);

        }

    }


}


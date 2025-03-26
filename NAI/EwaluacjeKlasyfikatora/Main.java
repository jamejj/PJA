package EwaluacjeKlasyfikatora;

public class Main {
    public static void main(String[] args) {

        Ewaluacje ewaluacje = new Ewaluacje(80,20,10,40);
        System.out.println(ewaluacje.accuracy());
        System.out.println(ewaluacje.precision());
        System.out.println(ewaluacje.recall());
        System.out.println(ewaluacje.F1());
    }
}
package PJA.GUI.GUI02.Zad01;

public class Kwadrat extends Figura {

    private int a;

    public Kwadrat(String kolor, int a) {
        super(kolor);
        this.a = a;
    }

    @Override
    int obliczPole() {
        return a*a;
    }

    @Override
    int obliczObwod() {
        return 4*a;
    }

    @Override
    String figuraInfo() {
        return "Kwadrat koloru " + kolor + " o boku " + a + " ma pole o powierzchni " + obliczPole() + " a obwod " + obliczObwod();
    }

    @Override
    public String toString() {
        return kolor + " kwadrat";
    }
}

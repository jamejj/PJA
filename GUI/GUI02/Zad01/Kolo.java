package PJA.GUI.GUI02.Zad01;

public class Kolo extends Figura {

    private int r;

    public Kolo(String kolor, int r) {
        super(kolor);
        this.r = r;
    }

    @Override
    int obliczPole() {
        return (int) Math.pow(Math.PI*r,2);
    }

    @Override
    int obliczObwod() {
        return (int)(2*Math.PI*r);
    }

    @Override
    String figuraInfo() {
        return "Kolo koloru " + kolor + " o promieniu " + r + " ma pole o powierzchni " + obliczPole() + " a obwod " + obliczObwod();
    }

    @Override
    public String toString() {
        return kolor + " kolo";
    }
}
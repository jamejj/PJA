package PJA.GUI.GUI02.Zad01;

public abstract class Figura {

    String kolor;

    public Figura(String kolor) {
        this.kolor = kolor;
    }

    abstract int obliczPole();
    abstract int obliczObwod();
    abstract String figuraInfo();
}
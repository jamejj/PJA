package PJA.GUI.GUI02.Zad03;

public class Square implements Comparable<Square>{

    private int length;
    private int number;
    private static int counter = 1;

    public Square(int length) {
        this.length = length;
        this.number = counter++;
    }

    public int getArea(){
        return length*length;
    }

    @Override
    public String toString() {
        return "(" + number + "): " + getArea();
    }

    @Override
    public int compareTo(Square square) {
        return Integer.compare(this.getArea(), square.getArea());

    }
}
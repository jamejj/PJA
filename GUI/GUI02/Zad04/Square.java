package PJA.GUI.GUI02.Zad04;

public class Square implements Figure{

    private int length;
    private int number;
    private static int counter = 1;

    public Square(int length) {
        if (length > max){
            throw new TooBigSquareException("Maximum length is " + max);
        }else
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

}

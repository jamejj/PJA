package PJA.GUI.GUI02.Zad04;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Square square1 = new Square(5);
        Square square2 = new Square(6);
        Square square3 = new Square(7);
        Square square4 = new Square(8);
        Square square5 = new Square(9);

        ArrayList<Square> squares = new ArrayList<>();
        squares.addAll(Arrays.asList(square5, square1, square3, square4, square2));

        System.out.println(squares);



    }
}

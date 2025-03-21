package PJA.GUI.GUI02.Zad04;

public interface Figure {

    int max = 6;

    int getArea();
    default int getPerimeter(){
        return max;
    };
}

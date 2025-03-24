package Perceptron;

public class IrisData {
    private double[] cechy;
    private boolean czySetosa;

    public IrisData(double[] cechy, boolean czySetosa) {
        this.cechy = cechy;
        this.czySetosa = czySetosa;
    }

    public double[] getCechy() {
        return cechy;
    }

    public boolean isCzySetosa() {
        return czySetosa;
    }
}

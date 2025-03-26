package Ewaluacje;


public class Ewaluacje {

    private int tp;
    private int fn;
    private int fp;
    private int tn;

    public Ewaluacje(int tp, int fn, int fp, int tn) {
        this.tp = tp;
        this.fn = fn;
        this.fp = fp;
        this.tn = tn;
    }

    public double accuracy() {
        return (double) (tp + tn) /(tp + fp + tn + fn);
    }

    public double precision() {
        return (double) tp / (tp + fp);
    }

    public double recall() {
        return (double) tp / (tp + fn);
    }

    public double F1() {
        return (double) 2 * precision() * recall() / (precision() + recall());
    }
}
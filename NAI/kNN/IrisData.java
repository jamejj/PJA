package kNN;

public class IrisData {
    double sepalLengthInCm;
    double sepalWidthInCm;
    double petalLengthInCm;
    double petalWidthInCm;
    String type;


    public IrisData(double sepalLengthInCm, double sepalWidthInCm, double petalLengthInCm, double petalWidthInCm, String type) {
        this.sepalLengthInCm = sepalLengthInCm;
        this.sepalWidthInCm = sepalWidthInCm;
        this.petalLengthInCm = petalLengthInCm;
        this.petalWidthInCm = petalWidthInCm;
        this.type = type;
    }

    @Override
    public String toString() {
        return "IrisData -> (" +
                "sepalLengthInCm: " + sepalLengthInCm +
                ", sepalWidthInCm: " + sepalWidthInCm +
                ", petalLengthInCm: " + petalLengthInCm +
                ", petalWidthInCm:" + petalWidthInCm +
                ", type: " + type  + '\n' ;
    }

    public double getSepalLengthInCm() {
        return sepalLengthInCm;
    }

    public double getSepalWidthInCm() {
        return sepalWidthInCm;
    }

    public double getPetalLengthInCm() {
        return petalLengthInCm;
    }

    public double getPetalWidthInCm() {
        return petalWidthInCm;
    }

    public String getType() {
        return type;
    }
}
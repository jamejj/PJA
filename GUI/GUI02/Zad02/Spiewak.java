package PJA.GUI.GUI02.Zad02;

public abstract class Spiewak {

    private String nazwisko;
    private static int nrStartowy = 1;
    private int numerStartowy;

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        this.numerStartowy = nrStartowy++;
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return "(" + numerStartowy + ")" + nazwisko + ": " + spiewaj() ;
    }

    public static Spiewak najglosniej(Spiewak[] spiewak) {
        int countMax = 0;
        Spiewak najglosniejszySpiewak = spiewak[0];
        String znaki = "ABCDEFGHIJKLMNOPQSTUVWXYZ";

        for (int i = 0; i < spiewak.length; i++) {
            int count = 0;

            for (int j = 0; j < znaki.length(); j++) {
                if (spiewak[i].spiewaj().contains(String.valueOf(znaki.charAt(j)))) {
                    count++;
                }
            }
            if (count > countMax) {
                countMax = count;
                najglosniejszySpiewak = spiewak[i];
            }
        }

        return najglosniejszySpiewak;
    }


}

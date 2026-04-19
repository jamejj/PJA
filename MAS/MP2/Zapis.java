package MAS.MP2;

public class Zapis {

    private String data;
    private String status;
    private double koszt;

    private Klient klient;
    private Zajecia zajecia;


    public Zapis(String data, String status, double koszt, Klient klient, Zajecia zajecia) {
        this.data = data;
        this.status = status;
        this.koszt = koszt;
        this.klient = klient;
        this.zajecia = zajecia;

        klient.dodajZapis(this);
        zajecia.dodajZapis(this);
    }

    @Override
    public String toString() {
        return "Zapis{" +
                "\n\tData: " + data +
                "\n\tStatus: " + status +
                "\n\tKoszt: " + koszt +
                "\n\tKlient: " + klient +
                "\n\tZajecia: " + zajecia;
    }
}

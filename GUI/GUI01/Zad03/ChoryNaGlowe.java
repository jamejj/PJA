public class ChoryNaGlowe extends Pacjent {
    public ChoryNaGlowe(String s) {
        super(s);
    }

    @Override
    public String choroba() {
        return "głowa";
    }

    @Override
    public String leczenie() {
        return "aspiryna";
    }
}
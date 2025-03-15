public class ChoryNaDyspepsje extends Pacjent {
    public ChoryNaDyspepsje(String s) {
        super(s);
    }

    @Override
    public String choroba() {
        return "dyspensja";
    }

    @Override
    public String leczenie() {
        return "węgiel";
    }
}
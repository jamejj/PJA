package MAS.MP3.overlapping;

import java.util.EnumSet;

public class CzlonekKlubu {

    private String imie;
    private String nazwisko;
    private EnumSet<Rola> role;

    public CzlonekKlubu(String imie, String nazwisko, EnumSet<Rola> role) {
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Członek klubu musi mieć przynajmniej jedną rolę.");
        }
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.role = role;
    }

    public boolean czyMaRole(Rola rola) {
        return role.contains(rola);
    }

    public EnumSet<Rola> getRole() {
        return role;
    }

    public void dodajRole(Rola rola) {
        role.add(rola);
    }
}
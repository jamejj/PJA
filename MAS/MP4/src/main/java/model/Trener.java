package MAS.MP4.src.main.java.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Trener extends Osoba {

    @ElementCollection
    @Builder.Default
    private Set<String> specjalizacja = new HashSet<>();

    @Min(0)
    private double stawkaGodzinowa;

    public double getPensja() {
        return stawkaGodzinowa * 160;
    }


    @ManyToOne
    @JoinColumn(name = "silownia_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Silownia silownia;
}

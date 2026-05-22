package MAS.MP4.src.main.java.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Klient extends Osoba {

    @NotBlank
    private String numerKlienta;

    private LocalDate dataRejestracji;

    @ElementCollection
    @Builder.Default
    private Set<String> celeTreningowe = new HashSet<>();

    private String rodzajKarnetu;
//Z atrybutem==================================================================
    @OneToMany(mappedBy = "klient", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<PrzypisaniePlanu> przypisaniaPlanow = new HashSet<>();

}

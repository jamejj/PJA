package MAS.MP4.src.main.java.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanTreningowy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nazwa;

    private String opis;

    @Enumerated(EnumType.STRING)
    private PoziomTrudnosci poziom;

    @OneToMany(mappedBy = "planTreningowy", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Cwiczenie> cwiczenia = new HashSet<>();

    @OneToMany(mappedBy = "planTreningowy", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<PrzypisaniePlanu> przypisaniaPlanow = new HashSet<>();
}

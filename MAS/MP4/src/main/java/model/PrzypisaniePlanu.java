package MAS.MP4.src.main.java.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrzypisaniePlanu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataOd;

    private LocalDate dataDo;

    private String uwagi;

    @ManyToOne
    @JoinColumn(name = "klient_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Klient klient;

    @ManyToOne
    @JoinColumn(name = "plan_treningowy_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PlanTreningowy planTreningowy;
}

package MAS.MP4.src.main.java.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cwiczenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nazwa;

    private String opis;

    @Min(1)
    private int serie;

    @Min(1)
    private int powtorzenia;

    @ManyToOne
    @JoinColumn(name = "plan_treningowy_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PlanTreningowy planTreningowy;
}

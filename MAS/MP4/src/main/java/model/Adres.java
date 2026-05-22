package MAS.MP4.src.main.java.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adres {

    @NotBlank
    private String miasto;

    @NotBlank
    private String ulica;

    @NotBlank
    private String numerBudynku;

    private String numerLokalu;

    @NotBlank
    private String kodPocztowy;
}
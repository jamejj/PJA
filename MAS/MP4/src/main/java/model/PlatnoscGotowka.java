package MAS.MP4.src.main.java.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PlatnoscGotowka extends Platnosc {

    private String potwierdzenie;
}
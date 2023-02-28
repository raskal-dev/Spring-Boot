package kalvin.rasamy.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nomCli, numCli;

    @Column(unique = true, nullable = false)
    String matriculeVoiture;

    String marqueVoiture, typeVoiture;

    int nbPlaceVoiture;

    double priceVoiture;
}

package kalvin.rasamy.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true, nullable = false)
    String matricule;

    String mark, type;

    int placeNumber;

    double price;



}

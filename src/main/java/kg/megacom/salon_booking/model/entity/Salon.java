package kg.megacom.salon_booking.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "salons")
@SQLDelete(sql = "UPDATE salons SET active = true WHERE id=?")
@Where(clause = "active=false")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String name;

    @NonNull
    String instagram;

    @NonNull
    boolean active = Boolean.FALSE;
}

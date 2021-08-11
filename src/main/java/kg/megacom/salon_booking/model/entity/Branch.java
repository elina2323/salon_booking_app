package kg.megacom.salon_booking.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "branches")
@SQLDelete(sql = "UPDATE branches SET active = true WHERE id=?")
@Where(clause = "active=false")
public class Branch{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @NonNull
    String address;

    @NonNull
    double lat;

    @NonNull
    double lon;

    @NonNull
    boolean active = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    Salon salon;

    public Branch() {
    }

    public Branch(Long contactId) {
    }

}

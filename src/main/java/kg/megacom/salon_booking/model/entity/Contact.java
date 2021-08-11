package kg.megacom.salon_booking.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "contacts")
public class Contact{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String phone;

    @NonNull
    String telegram;

    @NonNull
    String whatsApp;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    Branch branch;
}

package kg.megacom.salon_booking.model.entity;

import kg.megacom.salon_booking.model.enums.AdminStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "admins")
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String name;

    @NonNull
    String login;

    @NonNull
    String password;

    @Enumerated(value = EnumType.STRING)
    AdminStatus adminStatus;
}

package kg.megacom.salon_booking.model.entity;

import kg.megacom.salon_booking.model.enums.ReservedStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "reserved_hours")
public class ReservedHour{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalTime startTime;

    LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "master_work_day_id")
    MasterWorkDay masterWorkDay;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @Enumerated(value = EnumType.STRING)
    ReservedStatus reservedStatus;

}
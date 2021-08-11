package kg.megacom.salon_booking.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "master_work_days")
public class MasterWorkDay{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "master_id")
    Master master;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    Branch branch;

    @NonNull
    LocalDate workDay;

    @NonNull
    LocalTime startTime;

    @NonNull
    LocalTime endTime;

    @CreationTimestamp
    LocalDateTime addDate;

    @UpdateTimestamp
    LocalDateTime editDate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    Admin admin;

}

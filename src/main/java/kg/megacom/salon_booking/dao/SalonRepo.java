package kg.megacom.salon_booking.dao;

import kg.megacom.salon_booking.model.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepo extends JpaRepository<Salon, Long> {

}

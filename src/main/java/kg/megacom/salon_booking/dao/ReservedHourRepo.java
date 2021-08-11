package kg.megacom.salon_booking.dao;

import kg.megacom.salon_booking.model.entity.ReservedHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservedHourRepo extends JpaRepository<ReservedHour, Long> {

    List<ReservedHour> findAllByMasterWorkDay_Id(Long masterWorkDay_id);
}

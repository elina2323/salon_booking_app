package kg.megacom.salon_booking.dao;

import kg.megacom.salon_booking.model.entity.MasterWorkDay;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface MasterWorkDayRepo  extends JpaRepository<MasterWorkDay, Long> {

    List<MasterWorkDay> findAllByBranch_IdAndWorkDay(Long branch_id, @NonNull LocalDate workDay);

    boolean existsByIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(Long id, @NonNull LocalTime startTime, @NonNull LocalTime endTime);
}

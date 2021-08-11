package kg.megacom.salon_booking.dao;

import kg.megacom.salon_booking.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {

    List<Branch> findAllActiveBranchesBySalon_Id(Long salon_id);
}

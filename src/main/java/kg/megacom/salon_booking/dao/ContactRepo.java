package kg.megacom.salon_booking.dao;

import kg.megacom.salon_booking.model.entity.Contact;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

    Contact findContactByBranch_IdAndBranch_Active(Long branch_id, @NonNull boolean branch_active);
}

package kg.megacom.salon_booking.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchDTO{

    Long id;
    String address;
    double lat;
    double lon;
    boolean active;
    SalonDTO salon;
    List<ContactDTO> contacts;
}

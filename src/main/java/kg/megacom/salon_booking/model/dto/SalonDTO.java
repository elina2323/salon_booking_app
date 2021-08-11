package kg.megacom.salon_booking.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalonDTO{

    Long id;
    String name;
    String instagram;
    boolean active;
}

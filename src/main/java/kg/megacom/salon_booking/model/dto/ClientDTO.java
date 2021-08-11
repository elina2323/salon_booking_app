package kg.megacom.salon_booking.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDTO{

    Long id;
    String name;
    String phone;
    String email;
    String pin;
}

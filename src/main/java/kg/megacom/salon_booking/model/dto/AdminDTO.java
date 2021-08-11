package kg.megacom.salon_booking.model.dto;

import kg.megacom.salon_booking.model.enums.AdminStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminDTO {

    Long id;
    String name;
    String login;
    String password;
    AdminStatus adminStatus;

}
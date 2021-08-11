package kg.megacom.salon_booking.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactDTO{

    Long id;
    String phones;
    String telegram;
    String whatsApp;

}

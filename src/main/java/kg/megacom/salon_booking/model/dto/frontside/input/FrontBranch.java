package kg.megacom.salon_booking.model.dto.frontside.input;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FrontBranch {

    Long branchId;
    Long salonId;
    String address;
    double lat;
    double lon;
    List<String> phone;
    List<String> telegram;
    List<String> whatsApp;

}

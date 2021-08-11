package kg.megacom.salon_booking.controller.v1;

import kg.megacom.salon_booking.model.dto.frontside.input.FrontReservedHour;
import kg.megacom.salon_booking.service.ReservedHourService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@AllArgsConstructor
public class ReservationController{

    private final ReservedHourService reservedHourService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FrontReservedHour frontReservedHour) {
        return new ResponseEntity<>(reservedHourService.saveReservation(frontReservedHour), HttpStatus.CREATED);
    }

    @GetMapping("/findId")
    public ResponseEntity<List<?>> getId(@RequestParam Long masterWorkId){
        return new ResponseEntity<>(reservedHourService.findByMasterWorkDayId(masterWorkId), HttpStatus.FOUND);
    }
}

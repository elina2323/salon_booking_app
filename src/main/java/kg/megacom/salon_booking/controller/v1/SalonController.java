package kg.megacom.salon_booking.controller.v1;

import kg.megacom.salon_booking.controller.base.BaseController;
import kg.megacom.salon_booking.model.dto.SalonDTO;
import kg.megacom.salon_booking.service.SalonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salon")
@AllArgsConstructor
public class SalonController implements BaseController<SalonDTO, Long> {

    private final SalonService salonService;

    @Override
    public ResponseEntity<?> save(SalonDTO salonDTO) {

        return new ResponseEntity<>(salonService.save(salonDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(SalonDTO salonDTO) {

        SalonDTO salonDTOFound = salonService.findById(salonDTO.getId());
        return new ResponseEntity<>(salonService.update(salonDTOFound), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {

        return new ResponseEntity<>(salonService.findById(id), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<?>> findAll() {

        return new ResponseEntity<>(salonService.findAll(), HttpStatus.FOUND);
    }
}


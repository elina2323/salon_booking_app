package kg.megacom.salon_booking.controller.v1;

import kg.megacom.salon_booking.controller.base.BaseController;
import kg.megacom.salon_booking.model.dto.MasterDTO;
import kg.megacom.salon_booking.service.MasterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/master")
@AllArgsConstructor
public class MasterController implements BaseController<MasterDTO, Long> {

    private final MasterService masterService;

    @Override
    public ResponseEntity<?> save(MasterDTO masterDTO) {

        return new ResponseEntity<>(masterService.save(masterDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(MasterDTO masterDTO) {

        MasterDTO masterDTOFound = masterService.findById(masterDTO.getId());
        return new ResponseEntity<>(masterService.update(masterDTOFound), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {

        return new ResponseEntity<>(masterService.findById(id), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<?>> findAll() {

        return new ResponseEntity<>(masterService.findAll(), HttpStatus.FOUND);
    }
}

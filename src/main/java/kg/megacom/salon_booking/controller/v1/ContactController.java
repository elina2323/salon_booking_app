package kg.megacom.salon_booking.controller.v1;

import kg.megacom.salon_booking.controller.base.BaseController;
import kg.megacom.salon_booking.model.dto.ContactDTO;
import kg.megacom.salon_booking.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@AllArgsConstructor
public class ContactController implements BaseController<ContactDTO, Long> {

    private final ContactService contactService;

    @Override
    public ResponseEntity<?> save(ContactDTO contactDTO) {

        return new ResponseEntity<>(contactService.save(contactDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(ContactDTO contactDTO) {

        ContactDTO contactDTOFound = contactService.findById(contactDTO.getId());
        return new ResponseEntity<>(contactService.update(contactDTOFound), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {

        return new ResponseEntity<>(contactService.findById(id), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<?>> findAll() {

        return new ResponseEntity<>(contactService.findAll(), HttpStatus.FOUND);
    }
}

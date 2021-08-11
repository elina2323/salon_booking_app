package kg.megacom.salon_booking.controller.v1;

import kg.megacom.salon_booking.controller.base.BaseController;
import kg.megacom.salon_booking.model.dto.ClientDTO;
import kg.megacom.salon_booking.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController implements BaseController<ClientDTO, Long> {

    private final ClientService clientService;

    @Override
    public ResponseEntity<?> save(ClientDTO clientDTO) {

        return new ResponseEntity<>(clientService.save(clientDTO), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<?> update(ClientDTO clientDTO) {

        ClientDTO clientDTOFound = clientService.findById(clientDTO.getId());
        return new ResponseEntity<>(clientService.update(clientDTOFound), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {

        return new ResponseEntity<>(clientService.findById(id), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<?>> findAll() {

        return new ResponseEntity<>(clientService.findAll(), HttpStatus.FOUND);
    }
}

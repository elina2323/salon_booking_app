package kg.megacom.salon_booking.controller.v1;

import kg.megacom.salon_booking.controller.base.BaseController;
import kg.megacom.salon_booking.model.dto.AdminDTO;
import kg.megacom.salon_booking.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController implements BaseController<AdminDTO, Long> {

    private final AdminService adminService;

    @Override
    public ResponseEntity<?> save(AdminDTO adminDTO) {
        return new ResponseEntity<>(adminService.save(adminDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(AdminDTO adminDTO) {
        AdminDTO adminDTOFound = adminService.findById(adminDTO.getId());
        return new ResponseEntity<>(adminService.update(adminDTOFound), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return new ResponseEntity<>(adminService.findById(id), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<?>> findAll() {

        return new ResponseEntity<>(adminService.findAll(), HttpStatus.FOUND);
    }
}

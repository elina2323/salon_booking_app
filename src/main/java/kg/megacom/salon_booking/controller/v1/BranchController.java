package kg.megacom.salon_booking.controller.v1;

import kg.megacom.salon_booking.model.dto.BranchDTO;
import kg.megacom.salon_booking.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branch")
@AllArgsConstructor
public class BranchController{

    private final BranchService branchService;

    @PostMapping("/save")
    public ResponseEntity<?> save(BranchDTO branchDTO) {
        return new ResponseEntity<>(branchService.saveBranch(branchDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        return new ResponseEntity<>(branchService.findById(id), HttpStatus.FOUND);
    }
}


package kg.megacom.salon_booking.controller.v1;

import kg.megacom.salon_booking.model.dto.frontside.input.FrontMasterWorkDay;
import kg.megacom.salon_booking.service.MasterWorkDayService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/master-work-day")
@AllArgsConstructor
public class MasterWorkDayController{

    private final MasterWorkDayService masterWorkDayService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FrontMasterWorkDay frontMasterWorkDay) {

        return new ResponseEntity<>(masterWorkDayService.saveMasterWorkDay(frontMasterWorkDay), HttpStatus.CREATED);
    }

    @GetMapping("/findByBranch")
    public ResponseEntity<List<?>> findBranchByIdAndDate(@RequestParam Long branchId,
                                                         @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
        return new ResponseEntity<>(masterWorkDayService.findByBranch_IdAndWorkDay(branchId, date), HttpStatus.FOUND);
    }
}

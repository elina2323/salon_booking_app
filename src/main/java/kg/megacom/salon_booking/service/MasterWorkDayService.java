package kg.megacom.salon_booking.service;

import kg.megacom.salon_booking.model.dto.MasterWorkDayAppDTO;
import kg.megacom.salon_booking.model.dto.MasterWorkDayDTO;
import kg.megacom.salon_booking.model.dto.frontside.input.FrontMasterWorkDay;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface MasterWorkDayService{

    List<MasterWorkDayAppDTO> findByBranch_IdAndWorkDay(Long branchId, LocalDate localDate);
    boolean recordTime(Long recordId, LocalTime startTime, LocalTime endTime);
    MasterWorkDayDTO saveMasterWorkDay(FrontMasterWorkDay frontMasterWorkDay);
    MasterWorkDayDTO findByMasterWorkDayId(Long masterWorkDayId);
}

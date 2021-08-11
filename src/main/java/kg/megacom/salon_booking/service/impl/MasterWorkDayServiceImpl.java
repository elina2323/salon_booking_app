package kg.megacom.salon_booking.service.impl;

import kg.megacom.salon_booking.dao.MasterWorkDayRepo;
import kg.megacom.salon_booking.exception.ResourceNotFoundException;
import kg.megacom.salon_booking.mapper.MasterWorkDayMapper;
import kg.megacom.salon_booking.model.dto.MasterWorkDayAppDTO;
import kg.megacom.salon_booking.model.dto.MasterWorkDayDTO;
import kg.megacom.salon_booking.model.dto.frontside.input.FrontMasterWorkDay;
import kg.megacom.salon_booking.model.entity.MasterWorkDay;
import kg.megacom.salon_booking.service.AdminService;
import kg.megacom.salon_booking.service.BranchService;
import kg.megacom.salon_booking.service.MasterService;
import kg.megacom.salon_booking.service.MasterWorkDayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MasterWorkDayServiceImpl implements MasterWorkDayService {

    private final MasterWorkDayRepo masterWorkDayRepo;

    private final MasterService masterService;

    private final BranchService branchService;

    private final AdminService adminService;

    @Override
    public List<MasterWorkDayAppDTO> findByBranch_IdAndWorkDay(Long branchId, LocalDate localDate) {
        log.info("IN MasterWorkDayServiceImpl findByBranch_UuidAndWorkDay {}", branchId);
        List<MasterWorkDay> masterWorkDayList = masterWorkDayRepo.findAllByBranch_IdAndWorkDay(branchId, localDate);
        return MasterWorkDayMapper.INSTANCE.toMasterWorkDayAppDTO(masterWorkDayList);
    }

    @Override
    public boolean recordTime(Long recordId, LocalTime startTime, LocalTime endTime) {
        log.info("IN MasterWorkDayServiceImpl recordTime {}", recordId);
        return masterWorkDayRepo.existsByIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(recordId, startTime, endTime);

    }

    @Override
    public MasterWorkDayDTO saveMasterWorkDay(FrontMasterWorkDay frontMasterWorkDay) {
        log.info("IN MasterWorkDayServiceImpl saveMasterWorkDay {}", frontMasterWorkDay);
        MasterWorkDayDTO masterWorkDayDTO = new MasterWorkDayDTO();
        masterWorkDayDTO.setAdmin(adminService.findById(frontMasterWorkDay.getAdminId()));
        masterWorkDayDTO.setBranch(branchService.findById(frontMasterWorkDay.getBranchId()));
        masterWorkDayDTO.setMaster(masterService.findById(frontMasterWorkDay.getMasterId()));
        masterWorkDayDTO.setWorkDay(frontMasterWorkDay.getWorkDay());
        masterWorkDayDTO.setStartTime(frontMasterWorkDay.getStartTime());
        masterWorkDayDTO.setEndTime(frontMasterWorkDay.getEndTime());
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm")));
        masterWorkDayDTO.setAddDate(dateTime);
        masterWorkDayDTO.setEditDate(dateTime);
        return MasterWorkDayMapper.INSTANCE.toMasterWorkDayDTO(masterWorkDayRepo.save(MasterWorkDayMapper.INSTANCE.toMasterWorkDay(masterWorkDayDTO)));
    }

    @Override
    public MasterWorkDayDTO findByMasterWorkDayId(Long masterWorkDayId)
            throws ResourceNotFoundException {
        log.info("IN MasterWorkDayServiceImpl getByMasterWorkDayUuid {}", masterWorkDayId);
        MasterWorkDay masterWorkDay = masterWorkDayRepo.findById(masterWorkDayId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Рабочий день мастера с таким id \"%s\" не найден" + masterWorkDayId));
        return MasterWorkDayMapper.INSTANCE.toMasterWorkDayDTO(masterWorkDay);
    }

}
package kg.megacom.salon_booking.service.impl;

import kg.megacom.salon_booking.dao.ReservedHourRepo;
import kg.megacom.salon_booking.mapper.ReservedHourMapper;
import kg.megacom.salon_booking.model.dto.ReservedHourDTO;
import kg.megacom.salon_booking.model.dto.frontside.input.FrontReservedHour;
import kg.megacom.salon_booking.model.entity.ReservedHour;
import kg.megacom.salon_booking.model.enums.ReservedStatus;
import kg.megacom.salon_booking.service.AdminService;
import kg.megacom.salon_booking.service.ClientService;
import kg.megacom.salon_booking.service.MasterWorkDayService;
import kg.megacom.salon_booking.service.ReservedHourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservedHourServiceImpl implements ReservedHourService {

    private final ReservedHourRepo reservedHourRepo;

    private final MasterWorkDayService masterWorkDayService;

    private final AdminService adminService;

    private final ClientService clientService;

    @Override
    public List<ReservedHourDTO> findByMasterWorkDayId(Long masterWorkDayId) {
        log.info("IN ReservedHourServiceImpl findByMasterWorkDayUuid {}", masterWorkDayId);
        List<ReservedHour> reservedHourList = reservedHourRepo.findAllByMasterWorkDay_Id(masterWorkDayId);
        return ReservedHourMapper.INSTANCE.toReservedHourDTOList(reservedHourList);
    }

    @Override
    public ReservedHourDTO saveReservation(FrontReservedHour frontReservedHour) {
        log.info("IN ReservedHourServiceImpl saveReservation {}", frontReservedHour);
        ReservedHourDTO reservedHourDTO = new ReservedHourDTO();
        reservedHourDTO.setAdmin(adminService.findById(frontReservedHour.getAdminId()));
        reservedHourDTO.setClient(clientService.findById(frontReservedHour.getClientId()));
        reservedHourDTO.setMasterWorkDay(masterWorkDayService.findByMasterWorkDayId(frontReservedHour.getMasterWorkDayId()));
        reservedHourDTO.setStartTime(frontReservedHour.getStartTime());
        reservedHourDTO.setEndTime(frontReservedHour.getEndTime());
        reservedHourDTO.setReservedStatus(ReservedStatus.NEW);


        boolean recordTime = masterWorkDayService.recordTime(reservedHourDTO.getMasterWorkDay()
                .getId(), reservedHourDTO.getMasterWorkDay().getStartTime(), reservedHourDTO.
                getMasterWorkDay().getEndTime());
        if (!recordTime) {
            throw new RuntimeException("Не входит в диапазон!");

        }

        List<ReservedHour> reservedHourList = reservedHourRepo.findAllByMasterWorkDay_Id(reservedHourDTO
                .getMasterWorkDay().getId());

        boolean isTimeAvailable = isAvailableBetween(reservedHourList, reservedHourDTO.getStartTime(), reservedHourDTO.getEndTime());
        if (isTimeAvailable){
            throw new RuntimeException("Запись на данное время невозможна");
        }

        ReservedHour reservedHour = ReservedHourMapper.INSTANCE.toReservedHour(reservedHourDTO);
        reservedHour = reservedHourRepo.save(reservedHour);
        return ReservedHourMapper.INSTANCE.toReservedHourDTO(reservedHour);
    }

    private boolean isAvailableBetween(List<ReservedHour> reservedHourList, LocalTime startTime, LocalTime endTime) {
        return reservedHourList.stream()
                .noneMatch(x ->
                        (x.getStartTime().isBefore(startTime) || x.getEndTime().isAfter(endTime))
                                || (x.getStartTime().equals(startTime) && x.getEndTime().equals(endTime)));
    }

}

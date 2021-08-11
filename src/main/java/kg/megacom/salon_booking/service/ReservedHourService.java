package kg.megacom.salon_booking.service;

import kg.megacom.salon_booking.model.dto.ReservedHourDTO;
import kg.megacom.salon_booking.model.dto.frontside.input.FrontReservedHour;

import java.util.List;

public interface ReservedHourService{

    List<ReservedHourDTO> findByMasterWorkDayId(Long masterWorkDayId);

    ReservedHourDTO saveReservation(FrontReservedHour frontReservedHour);
}

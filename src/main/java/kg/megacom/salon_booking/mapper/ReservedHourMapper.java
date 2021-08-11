package kg.megacom.salon_booking.mapper;

import kg.megacom.salon_booking.model.dto.ReservedHourDTO;
import kg.megacom.salon_booking.model.entity.ReservedHour;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservedHourMapper {

    ReservedHourMapper INSTANCE = Mappers.getMapper(ReservedHourMapper.class);

    ReservedHour toReservedHour(ReservedHourDTO reservedHourDTO);
    ReservedHourDTO toReservedHourDTO(ReservedHour reservedHour);

    List<ReservedHourDTO> toReservedHourDTOList(List<ReservedHour> reservedHoursList);

    List<ReservedHour> toReservedHourList(List<ReservedHourDTO> reservedHourDTOList);
}

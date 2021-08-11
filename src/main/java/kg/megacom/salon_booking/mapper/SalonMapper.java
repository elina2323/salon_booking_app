package kg.megacom.salon_booking.mapper;

import kg.megacom.salon_booking.model.dto.SalonDTO;
import kg.megacom.salon_booking.model.entity.Salon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalonMapper {

    SalonMapper INSTANCE = Mappers.getMapper(SalonMapper.class);

    SalonDTO toSalonDTO(Salon salon);

    Salon toSalon(SalonDTO salonDTO);

    List<Salon> toSalonList(List<SalonDTO> salonDTOList);

    List<SalonDTO> toSalonDTOList(List<Salon> salonList);
}

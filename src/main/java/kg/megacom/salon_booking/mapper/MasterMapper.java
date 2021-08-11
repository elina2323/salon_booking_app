package kg.megacom.salon_booking.mapper;

import kg.megacom.salon_booking.model.dto.MasterDTO;
import kg.megacom.salon_booking.model.entity.Master;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MasterMapper {

    MasterMapper INSTANCE = Mappers.getMapper(MasterMapper.class);

    Master toMaster(MasterDTO masterDTO);
    MasterDTO toMasterDTO(Master master);

    List<Master> toMasterList(List<MasterDTO> masterDTOList);
    List<MasterDTO> toMasterDTOList(List<Master> masterList);
}

package kg.megacom.salon_booking.mapper;

import kg.megacom.salon_booking.model.dto.MasterWorkDayAppDTO;
import kg.megacom.salon_booking.model.dto.MasterWorkDayDTO;
import kg.megacom.salon_booking.model.entity.MasterWorkDay;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface MasterWorkDayMapper {

    MasterWorkDayMapper INSTANCE = Mappers.getMapper(MasterWorkDayMapper.class);

    MasterWorkDay toMasterWorkDay(MasterWorkDayDTO masterWorkDayDTO);

    MasterWorkDayDTO toMasterWorkDayDTO(MasterWorkDay masterWorkDay);

    List<MasterWorkDay> toMasterWorkDayList(List<MasterWorkDayDTO> masterWorkDayDTOList);

    List<MasterWorkDayDTO> toMasterWorkDayDTOList(List<MasterWorkDay> masterWorkDayList);

    default List<MasterWorkDayAppDTO> toMasterWorkDayAppDTO(List<MasterWorkDay> masterWorkDayList){

        List<MasterWorkDayAppDTO> masterWorkDayAppDTOList = new ArrayList<>();
        for (MasterWorkDay m:masterWorkDayList){
            MasterWorkDayAppDTO masterWorkDayAppDTO = new MasterWorkDayAppDTO();
            masterWorkDayAppDTO.setMasterWorkDayId(m.getId());
            masterWorkDayAppDTO.setMasterName(m.getMaster().getName());
            masterWorkDayAppDTO.setStartTime(m.getStartTime());
            masterWorkDayAppDTO.setEndTime(m.getEndTime());
            masterWorkDayAppDTO.setWorkDay(m.getWorkDay());
            masterWorkDayAppDTOList.add(masterWorkDayAppDTO);
        }
        return masterWorkDayAppDTOList;
    }
}

package kg.megacom.salon_booking.mapper;

import kg.megacom.salon_booking.model.dto.AdminDTO;
import kg.megacom.salon_booking.model.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin toAdmin(AdminDTO adminDTO);
    AdminDTO toAdminDTO(Admin admin);

    List<Admin> toAdminList(List<AdminDTO> adminDTOList);
    List<AdminDTO> toAdminDTOList(List<Admin> adminList);
}

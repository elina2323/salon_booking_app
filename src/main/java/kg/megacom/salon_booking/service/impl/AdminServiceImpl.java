package kg.megacom.salon_booking.service.impl;

import kg.megacom.salon_booking.dao.AdminRepo;
import kg.megacom.salon_booking.mapper.AdminMapper;
import kg.megacom.salon_booking.model.dto.AdminDTO;
import kg.megacom.salon_booking.model.entity.Admin;
import kg.megacom.salon_booking.model.enums.AdminStatus;
import kg.megacom.salon_booking.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    @Override
    public AdminDTO save(AdminDTO adminDTO) {

        log.info("IN AdminServiceImpl save {}", adminDTO);
        adminDTO.setAdminStatus(AdminStatus.ACTIVE);
        Admin admin = AdminMapper.INSTANCE.toAdmin(adminDTO);
        admin = adminRepo.saveAndFlush(admin);
        return AdminMapper.INSTANCE.toAdminDTO(admin);
    }

    @Override
    public AdminDTO update(AdminDTO adminDTO) {

        log.info("IN AdminServiceImpl update {}", adminDTO);

        AdminDTO adminDTOFound = findById(adminDTO.getId());
        if (adminDTOFound == null){
            throw new ResourceNotFoundException("Администратор с таким id \"%s\" не найден.");
        }
        Admin admin = AdminMapper.INSTANCE.toAdmin(adminDTO);
        admin = adminRepo.saveAndFlush(admin);
        return AdminMapper.INSTANCE.toAdminDTO(admin);

    }

    @Override
    public void removeByID(Long id)
            throws ResourceNotFoundException {
        log.info("IN AdminServiceImpl removeById {}", id);
        Admin admin = adminRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Администратор с таким id \"%s\" не найден "
                        + id));
        admin.setAdminStatus(AdminStatus.INACTIVE);
        adminRepo.saveAndFlush(admin);
    }

    @Override
    public AdminDTO findById(Long id)

            throws ResourceNotFoundException {
        log.info("IN AdminServiceImpl findById {}", id);
        Admin admin = adminRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Администратор с таким id \"%s\" не найден" + id));
        return AdminMapper.INSTANCE.toAdminDTO(admin);
    }

    @Override
    public List<AdminDTO> findAll() {
        log.info("IN AdminServiceImpl findAll");
        return AdminMapper.INSTANCE.toAdminDTOList(adminRepo.findAll());
    }
}

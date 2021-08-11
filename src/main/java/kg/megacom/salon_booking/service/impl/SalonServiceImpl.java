package kg.megacom.salon_booking.service.impl;

import kg.megacom.salon_booking.dao.SalonRepo;
import kg.megacom.salon_booking.mapper.SalonMapper;
import kg.megacom.salon_booking.model.dto.SalonDTO;
import kg.megacom.salon_booking.model.entity.Salon;
import kg.megacom.salon_booking.service.SalonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepo salonRepo;

    @Override
    public SalonDTO save(SalonDTO salonDTO) {
        log.info("IN SalonServiceImpl save {}", salonDTO);
        Salon salon = SalonMapper.INSTANCE.toSalon(salonDTO);
        salon = salonRepo.saveAndFlush(salon);
        return SalonMapper.INSTANCE.toSalonDTO(salon);
    }

    @Override
    public SalonDTO update(SalonDTO salonDTO) {
        log.info("IN SalonServiceImpl update {}", salonDTO);
        SalonDTO salonDTOFound = findById(salonDTO.getId());
        if (salonDTOFound == null){
            throw new ResourceNotFoundException("Салон не найден.");
        }
        Salon salon = SalonMapper.INSTANCE.toSalon(salonDTOFound);
        salon = salonRepo.saveAndFlush(salon);
        return SalonMapper.INSTANCE.toSalonDTO(salon);
    }

    @Override
    public void removeByID(Long id) {
        log.info("IN SalonServiceImpl removeById {}", id);
        salonRepo.deleteById(id);
    }

    @Override
    public SalonDTO findById(Long id)
            throws ResourceNotFoundException {
        log.info("IN SalonServiceImpl findById {}", id);
        Salon salon = salonRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Салон с таким id \"%s\" не найден" + id));
        return SalonMapper.INSTANCE.toSalonDTO(salon);
    }

    @Override
    public List<SalonDTO> findAll() {
        log.info("IN SalonServiceImpl findAll");
        return SalonMapper.INSTANCE.toSalonDTOList(salonRepo.findAll(Sort.by("active")));
    }
}

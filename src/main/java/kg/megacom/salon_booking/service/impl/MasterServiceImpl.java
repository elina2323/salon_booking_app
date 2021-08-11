package kg.megacom.salon_booking.service.impl;

import kg.megacom.salon_booking.dao.MasterRepo;
import kg.megacom.salon_booking.mapper.MasterMapper;
import kg.megacom.salon_booking.model.dto.MasterDTO;
import kg.megacom.salon_booking.model.entity.Master;
import kg.megacom.salon_booking.service.MasterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MasterServiceImpl implements MasterService {

    private MasterRepo masterRepo;

    @Override
    public MasterDTO save(MasterDTO masterDTO) {
        log.info("IN MasterServiceImpl save {}", masterDTO);
        Master master = MasterMapper.INSTANCE.toMaster(masterDTO);
        master = masterRepo.saveAndFlush(master);
        return MasterMapper.INSTANCE.toMasterDTO(master);
    }

    @Override
    public MasterDTO update(MasterDTO masterDTO) {

        log.info("IN MasterServiceImpl update {}", masterDTO);

        MasterDTO masterDTOFound = findById(masterDTO.getId());
        if (masterDTOFound == null){
            throw new ResourceNotFoundException("Мастер не найден.");
        }

        Master master = MasterMapper.INSTANCE.toMaster(masterDTO);
        master = masterRepo.saveAndFlush(master);
        return MasterMapper.INSTANCE.toMasterDTO(master);
    }

    @Override
    public void removeByID(Long id) {
        log.info("IN MasterServiceImpl removeById {}", id);
        masterRepo.deleteById(id);

    }

    @Override
    public MasterDTO findById(Long id)
            throws ResourceNotFoundException {
        log.info("IN MasterServiceImpl findById {}", id);
        Master master = masterRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Мастер с таким id \"%s\" не найден" + id));
        return MasterMapper.INSTANCE.toMasterDTO(master);
    }

    @Override
    public List<MasterDTO> findAll() {

        log.info("IN MasterServiceImpl findAll");
        return MasterMapper.INSTANCE.toMasterDTOList(masterRepo.findAll());
    }
}

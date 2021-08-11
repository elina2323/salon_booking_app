package kg.megacom.salon_booking.service.impl;

import kg.megacom.salon_booking.dao.BranchRepo;
import kg.megacom.salon_booking.mapper.BranchMapper;
import kg.megacom.salon_booking.model.dto.BranchDTO;
import kg.megacom.salon_booking.model.entity.Branch;
import kg.megacom.salon_booking.service.BranchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepo branchRepo;

    @Override
    public BranchDTO saveBranch(BranchDTO branchDTO) {
        log.info("IN BranchServiceImpl save {}", branchDTO);
        Branch branch = BranchMapper.INSTANCE.toBranch(branchDTO);
        branch = branchRepo.saveAndFlush(branch);
        return BranchMapper.INSTANCE.toBranchDTO(branch);
    }


    @Override
    public BranchDTO findById(Long branchId)
            throws ResourceNotFoundException {
        log.info("IN BranchServiceImpl findById {}", branchId);
        Branch branch = branchRepo.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Филиал с таким id \"%s\" не найден" + branchId));
        return BranchMapper.INSTANCE.toBranchDTO(branch);
    }
}

package kg.megacom.salon_booking.service;

import kg.megacom.salon_booking.model.dto.BranchDTO;

public interface BranchService{

    BranchDTO saveBranch(BranchDTO branchDTO);
    BranchDTO findById(Long branchId);
}

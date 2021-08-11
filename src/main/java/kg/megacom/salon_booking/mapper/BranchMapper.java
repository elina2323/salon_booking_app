package kg.megacom.salon_booking.mapper;

import kg.megacom.salon_booking.model.dto.BranchDTO;
import kg.megacom.salon_booking.model.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BranchMapper {

    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    Branch toBranch(BranchDTO branch);

    BranchDTO toBranchDTO(Branch branch);

    List<BranchDTO> toBranchDTOList(List<Branch> branchList);

    List<Branch> toBranchList(List<BranchDTO> branchDTOList);
}

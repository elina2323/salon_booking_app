package kg.megacom.salon_booking.mapper;

import kg.megacom.salon_booking.model.dto.ClientDTO;
import kg.megacom.salon_booking.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toClientDTO(Client client);
    Client toClient(ClientDTO clientDTO);
    List<ClientDTO> toClientDTOList(List<Client> clientList);
    List<Client> toClientList(List<ClientDTO> clientDTOList);
}

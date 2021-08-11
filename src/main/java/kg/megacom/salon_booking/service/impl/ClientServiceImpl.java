package kg.megacom.salon_booking.service.impl;

import kg.megacom.salon_booking.dao.ClientRepo;
import kg.megacom.salon_booking.exception.ResourceNotFoundException;
import kg.megacom.salon_booking.mapper.ClientMapper;
import kg.megacom.salon_booking.model.dto.ClientDTO;
import kg.megacom.salon_booking.model.entity.Client;
import kg.megacom.salon_booking.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        log.info("IN ClientServiceImpl save {}", clientDTO);
        Client client = ClientMapper.INSTANCE.toClient(clientDTO);
        client.setPin((long) ((Math.random() * (9999 - 1000)) + 1000));
        client = clientRepo.saveAndFlush(client);
        return ClientMapper.INSTANCE.toClientDTO(client);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {

        log.info("IN ClientServiceImpl update {}", clientDTO);

        ClientDTO clientDTOFound = findById(clientDTO.getId());
        if (clientDTOFound == null){
            throw new ResourceNotFoundException("Клиент с таким id \"%s\" не найден.");
        }
        Client client = ClientMapper.INSTANCE.toClient(clientDTO);
        client = clientRepo.saveAndFlush(client);
        return ClientMapper.INSTANCE.toClientDTO(client);
    }

    @Override
    public void removeByID(Long id){
        log.info("IN ClientServiceImpl removeById {}", id);
        clientRepo.deleteById(id);
    }

    @Override
    public ClientDTO findById(Long id)

            throws ResourceNotFoundException {
        log.info("IN ClientServiceImpl findById {}", id);
        Client client = clientRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Клиент с таким id \"%s\" не найден" + id));
        return ClientMapper.INSTANCE.toClientDTO(client);
    }

    @Override
    public List<ClientDTO> findAll() {

        log.info("IN ClientServiceImpl findAll");
        return ClientMapper.INSTANCE.toClientDTOList(clientRepo.findAll());
    }
}

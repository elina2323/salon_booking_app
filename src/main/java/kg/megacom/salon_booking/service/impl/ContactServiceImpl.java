package kg.megacom.salon_booking.service.impl;

import kg.megacom.salon_booking.dao.ContactRepo;
import kg.megacom.salon_booking.mapper.ContactMapper;
import kg.megacom.salon_booking.model.dto.ContactDTO;
import kg.megacom.salon_booking.model.entity.Contact;
import kg.megacom.salon_booking.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepo contactRepo;


    @Override
    public ContactDTO save(ContactDTO contactDTO) {

        log.info("IN ContactServiceImpl save {}", contactDTO);

        Contact contact = ContactMapper.INSTANCE.toContact(contactDTO);
        contact = contactRepo.saveAndFlush(contact);
        return ContactMapper.INSTANCE.toContactDTO(contact);
    }

    @Override
    public ContactDTO update(ContactDTO contactDTO) {

        log.info("IN ContactServiceImpl update {}", contactDTO);

        ContactDTO contactDTOFound = findById(contactDTO.getId());
        if (contactDTOFound == null){
            throw new ResourceNotFoundException("Контакты не найдены.");
        }

        Contact contact = ContactMapper.INSTANCE.toContact(contactDTO);
        contact = contactRepo.saveAndFlush(contact);
        return ContactMapper.INSTANCE.toContactDTO(contact);
    }

    @Override
    public void removeByID(Long id) {
        log.info("IN ContactServiceImpl removeById {}", id);
        contactRepo.deleteById(id);
    }

    @Override
    public ContactDTO findById(Long id)
            throws ResourceNotFoundException {
        log.info("IN ContactServiceImpl findById {}", id);
        Contact contact = contactRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Контакт с таким id \"%s\" не найден" + id));
        return ContactMapper.INSTANCE.toContactDTO(contact);
    }

    @Override
    public List<ContactDTO> findAll() {
        log.info("IN ContactServiceImpl findAll");
        return ContactMapper.INSTANCE.toContactDTOList(contactRepo.findAll());
    }


    @Override
    public List<ContactDTO> saveAllContacts(List<ContactDTO> contacts, Long contactId) {
        List<Contact> contactList = ContactMapper.INSTANCE.toContactList(contacts);
        for (Contact contact : contactList){
            contact.setBranch(new Branch(contactId));
        }
        contactList = contactRepo.saveAllAndFlush(contactList);
        return ContactMapper.INSTANCE.toContactDTOList(contactList);
    }
}

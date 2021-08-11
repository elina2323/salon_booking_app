package kg.megacom.salon_booking.service;

import kg.megacom.salon_booking.model.dto.ContactDTO;
import kg.megacom.salon_booking.service.base.BaseService;

import java.util.List;

public interface ContactService extends BaseService<ContactDTO, Long> {

    List<ContactDTO> saveAllContacts(List<ContactDTO> contacts, Long contactId);
}


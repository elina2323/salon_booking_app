package kg.megacom.salon_booking.mapper;

import kg.megacom.salon_booking.model.dto.ContactDTO;
import kg.megacom.salon_booking.model.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    Contact toContact(ContactDTO contactDTO);
    ContactDTO toContactDTO(Contact contact);

    List<Contact> toContactList(List<ContactDTO> contactDTOList);

    List<ContactDTO> toContactDTOList(List<Contact> contactList);
}

package kg.megacom.salon_booking.service.base;

import java.util.List;

public interface BaseService<S, T> {

    S save(S s);
    S update(S s);
    void removeByID(T id);
    S findById(T id);
    List<S> findAll();
}

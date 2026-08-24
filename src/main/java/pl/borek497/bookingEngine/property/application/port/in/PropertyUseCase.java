package pl.borek497.bookingEngine.property.application.port.in;

import pl.borek497.bookingEngine.property.application.PropertySearchCriteria;
import pl.borek497.bookingEngine.property.domain.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyUseCase {

    List<Property> findAll();
    Optional<Property> findById(Long id);
    List<Property> findByProvince(String province);
    List<Property> search(PropertySearchCriteria criteria);
}

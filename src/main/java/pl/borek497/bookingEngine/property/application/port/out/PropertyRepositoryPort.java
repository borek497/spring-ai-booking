package pl.borek497.bookingEngine.property.application.port.out;

import pl.borek497.bookingEngine.property.application.PropertySearchCriteria;
import pl.borek497.bookingEngine.property.domain.Property;
import pl.borek497.bookingEngine.property.domain.Province;

import java.util.List;
import java.util.Optional;

public interface PropertyRepositoryPort {

    Optional<Property> findById(Long id);
    List<Property> findAll();
    List<Property> findByProvince(Province province);
    List<Property> search(PropertySearchCriteria criteria);
}

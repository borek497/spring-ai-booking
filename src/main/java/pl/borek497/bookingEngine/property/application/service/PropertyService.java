package pl.borek497.bookingEngine.property.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.borek497.bookingEngine.property.application.PropertySearchCriteria;
import pl.borek497.bookingEngine.property.application.port.in.PropertyUseCase;
import pl.borek497.bookingEngine.property.application.port.out.PropertyRepositoryPort;
import pl.borek497.bookingEngine.property.domain.model.Property;
import pl.borek497.bookingEngine.property.domain.model.Province;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class PropertyService implements PropertyUseCase {

    private final PropertyRepositoryPort repositoryPort;

    @Override
    public List<Property> findAll() {
        return repositoryPort.findAll();
    }

    @Override
    public Optional<Property> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Property> findByProvince(String province) {
        return repositoryPort.findByProvince(Province.fromName(province));
    }

    @Override
    public List<Property> search(PropertySearchCriteria criteria) {
        return repositoryPort.search(criteria);
    }
}

package pl.borek497.bookingEngine.property.adapter.out.persistence;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.property.application.PropertySearchCriteria;
import pl.borek497.bookingEngine.property.application.port.out.PropertyRepositoryPort;
import pl.borek497.bookingEngine.property.domain.model.Property;
import pl.borek497.bookingEngine.property.domain.model.Province;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
class PropertyRepositoryAdapter implements PropertyRepositoryPort {

    private final PropertyJpaRepository repository;
    private final PropertyPersistenceMapper mapper;

    @Override
    public Optional<Property> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Property> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Property> findByProvince(Province province) {
        return repository
                .findByProvince(province)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Property> search(PropertySearchCriteria criteria) {
        return repository
                .findAll(PropertySpecification.from(criteria))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}

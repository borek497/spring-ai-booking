package pl.borek497.bookingEngine.property.adapter.out.persistence;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.property.application.PropertySearchCriteria;
import pl.borek497.bookingEngine.property.application.port.out.PropertyRepositoryPort;
import pl.borek497.bookingEngine.property.domain.Property;
import pl.borek497.bookingEngine.property.domain.Province;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
class PropertyPersistenceAdapter implements PropertyRepositoryPort {

    private final PropertyJpaRepository propertyJpaRepository;
    private final PropertyPersistenceMapper mapper;

    @Override
    public Optional<Property> findById(Long id) {
        return propertyJpaRepository
                .findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Property> findAll() {
        return propertyJpaRepository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Property> findByProvince(Province province) {
        return propertyJpaRepository
                .findByProvince(province)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Property> search(PropertySearchCriteria criteria) {
        return propertyJpaRepository
                .findAll(PropertySpecification.from(criteria))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}

package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSearchCriteria;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.BookableUnitRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.property.domain.model.Status;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
class BookableUnitPersistenceAdapter implements BookableUnitRepositoryPort {

    private final BookableUnitJpaRepository jpaRepository;
    private final BookableUnitPersistenceMapper mapper;

    @Override
    public Optional<BookableUnit> findByBookableUnitId(Long bookableUnitId) {
        return jpaRepository
                .findById(bookableUnitId)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<BookableUnit> findByIdForUpdate(Long id) {
        return jpaRepository
                .findByIdForUpdate(id)
                .map(mapper::toDomain);
    }


    @Override
    public List<BookableUnit> findByPropertyId(Long propertyId) {
        return jpaRepository
                .findByPropertyId(propertyId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<BookableUnit> search(BookableUnitSearchCriteria criteria) {
        List<BookableUnit> units = findByPropertyId(criteria.propertyId());
        return units
                .stream()
                .filter(u -> u.getStatus() == Status.ACTIVE)
                .filter(u -> u.getMaxGuests() >= criteria.numberOfGuests())
                .toList();
    }
}

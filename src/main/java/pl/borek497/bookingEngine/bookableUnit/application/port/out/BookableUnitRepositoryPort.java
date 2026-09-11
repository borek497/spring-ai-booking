package pl.borek497.bookingEngine.bookableUnit.application.port.out;

import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;

import java.util.List;
import java.util.Optional;

public interface BookableUnitRepositoryPort {

    Optional<BookableUnit> findById(Long id);
    Optional<BookableUnit> findByIdForUpdate(Long id);
    List<BookableUnit> findByPropertyId(Long propertyId);
}

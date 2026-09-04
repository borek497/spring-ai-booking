package pl.borek497.bookingEngine.bookableUnit.application.port.in;

import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;

import java.util.List;

public interface BookableUnitUseCase {

    BookableUnit getById(Long id);
    List<BookableUnit> getByPropertyId(Long propertyId);
}

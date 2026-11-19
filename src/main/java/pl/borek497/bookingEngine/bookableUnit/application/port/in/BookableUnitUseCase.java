package pl.borek497.bookingEngine.bookableUnit.application.port.in;

import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSummary;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSearchCriteria;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;

import java.util.List;

public interface BookableUnitUseCase {

    BookableUnit getByBookableUnitId(Long id);
    List<BookableUnit> getByPropertyId(Long propertyId);
    List<BookableUnit> searchWithCriteria(BookableUnitSearchCriteria criteria);
    //BookableUnitStaffDetails getStaffDetailsById(Long id);
    BookableUnitSummary getDetailsById(Long id);
}

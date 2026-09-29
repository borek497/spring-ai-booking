package pl.borek497.bookingEngine.bookableUnit.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitDetails;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSearchCriteria;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.BookableUnitUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.ApartmentDetailsRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.BookableUnitRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.bookableUnit.domain.details.BookableUnitSpecificDetails;
import pl.borek497.bookingEngine.common.application.exceptions.EntityNotFoundException;
import pl.borek497.bookingEngine.bookableUnit.domain.details.ApartmentDetails;
import pl.borek497.bookingEngine.reservation.application.port.out.ReservationRepositoryPort;

import java.util.List;

@AllArgsConstructor
@Service
@Validated
class BookableUnitService implements BookableUnitUseCase {

    private BookableUnitRepositoryPort repository;
    private ReservationRepositoryPort reservationRepositoryPort;
    private ApartmentDetailsRepositoryPort apartmentDetailsRepositoryPort;

    @Override
    public BookableUnit getByBookableUnitId(Long bookableUnitId) {
        return repository
                .findByBookableUnitId(bookableUnitId)
                .orElseThrow(() -> new EntityNotFoundException(BookableUnit.class, bookableUnitId));
    }

    @Override
    public List<BookableUnit> getByPropertyId(Long propertyId) {
        return repository.findByPropertyId(propertyId);
    }

    @Override
    public List<BookableUnit> search(BookableUnitSearchCriteria criteria) {
        return repository
                .search(criteria)
                .stream()
                .filter(unit -> !reservationRepositoryPort.existsOverlappingReservation(
                        unit.getId(),
                        criteria.startDate(),
                        criteria.endDate()
                ))
                .filter(unit -> unit.getBookableUnitType() == criteria.bookableUnitType())
                .toList();
    }

    @Override
    public BookableUnitDetails getDetailsById(Long bookableUnitId) {
        BookableUnit bookableUnit = getByBookableUnitId(bookableUnitId);
        BookableUnitSpecificDetails details = switch (bookableUnit.getBookableUnitType()) {
            case APARTMENT -> apartmentDetailsRepositoryPort
                    .findByBookableUnitId(bookableUnit.getId())
                    .orElseThrow(() -> new EntityNotFoundException(ApartmentDetails.class, bookableUnitId));
            default -> throw new IllegalArgumentException("Unrecognized bookableUnitType: " + bookableUnit.getBookableUnitType());
        };

        return new BookableUnitDetails(bookableUnit, details);
    }
}

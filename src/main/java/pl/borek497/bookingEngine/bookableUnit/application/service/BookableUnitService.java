package pl.borek497.bookingEngine.bookableUnit.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSearchCriteria;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.BookableUnitUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.BookableUnitRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.exceptions.EntityNotFoundException;
import pl.borek497.bookingEngine.reservation.application.port.out.ReservationRepositoryPort;

import java.util.List;

@AllArgsConstructor
@Service
@Validated
class BookableUnitService implements BookableUnitUseCase {

    private BookableUnitRepositoryPort repository;
    private ReservationRepositoryPort reservationRepositoryPort;

    @Override
    public BookableUnit getById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(BookableUnit.class, id));
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
}

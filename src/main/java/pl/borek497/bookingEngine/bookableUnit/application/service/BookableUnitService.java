package pl.borek497.bookingEngine.bookableUnit.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSummary;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSearchCriteria;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.BookableUnitUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.*;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitType;
import pl.borek497.bookingEngine.bookableUnit.domain.details.*;
import pl.borek497.bookingEngine.common.application.exceptions.EntityNotFoundException;
import pl.borek497.bookingEngine.reservation.application.port.out.ReservationRepositoryPort;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

import java.util.List;

@AllArgsConstructor
@Service
@Validated
class BookableUnitService implements BookableUnitUseCase {

    private BookableUnitRepositoryPort bookableUnitRepositoryPort;
    private ReservationRepositoryPort reservationRepositoryPort;
    private ApartmentDetailsRepositoryPort apartmentDetailsRepositoryPort;
    private HotelRoomDetailsRepositoryPort hotelRoomDetailsRepositoryPort;
    private GuestHouseRoomDetailsRepositoryPort guestHouseRoomDetailsRepositoryPort;
    private CottageDetailsRepositoryPort cottageDetailsRepositoryPort;

    @Override
    public BookableUnit getByBookableUnitId(Long bookableUnitId) {
        return bookableUnitRepositoryPort
                .findByBookableUnitId(bookableUnitId)
                .orElseThrow(() -> new EntityNotFoundException(BookableUnit.class, bookableUnitId));
    }

    @Override
    public List<BookableUnit> getByPropertyId(Long propertyId) {
        return bookableUnitRepositoryPort.findByPropertyId(propertyId);
    }

    @Override
    public List<BookableUnit> searchWithCriteria(BookableUnitSearchCriteria criteria) {
        if (criteria.startDate() == null || criteria.endDate() == null) {
            throw new IllegalArgumentException("Start date and end date are required");
        }

        if (!criteria.endDate().isAfter(criteria.startDate())) {
            throw new IllegalArgumentException("End date must be after start date");
        }

        return bookableUnitRepositoryPort
                .searchWithCriteria(criteria)
                .stream()
                .filter(unit -> unit.getBookableUnitType() == criteria.bookableUnitType())
                .filter(unit -> {
                    if (unit.getBookableUnitType() == BookableUnitType.CAMPING) {
                        return hasEnoughCampingCapacity(unit, criteria);
                    } else {
                        return !reservationRepositoryPort.existsOverlappingReservation(
                                unit.getId(),
                                criteria.startDate(),
                                criteria.endDate()
                        );
                    }
                }).toList();
    }

    private boolean hasEnoughCampingCapacity(BookableUnit unit, BookableUnitSearchCriteria criteria) {
        List<Reservation> overlappingReservations = reservationRepositoryPort
                .findOverlappingReservations(
                        unit.getId(),
                        criteria.startDate(),
                        criteria.endDate()
                );

        return criteria
                .startDate()
                .datesUntil(criteria.endDate())
                .allMatch(night -> {
                            long occupiedPlaces = overlappingReservations
                                    .stream()
                                    .filter(reservation ->
                                            !night.isBefore(reservation.getStartDate()) && night.isBefore(reservation.getEndDate())
                                    )
                                    .mapToLong(Reservation::getGuestsNumber)
                                    .sum();

                            return occupiedPlaces + criteria.numberOfGuests() <= unit.getMaxGuests();
                        }
                );
    }

    @Override
    public BookableUnitSummary getDetailsById(Long bookableUnitId) {
        BookableUnit bookableUnit = getByBookableUnitId(bookableUnitId);
        BookableUnitDetails details = switch (bookableUnit.getBookableUnitType()) {
            case APARTMENT -> apartmentDetailsRepositoryPort
                    .findByBookableUnitId(bookableUnit.getId())
                    .orElseThrow(() -> new EntityNotFoundException(ApartmentDetails.class, bookableUnitId));
            case HOTEL_ROOM -> hotelRoomDetailsRepositoryPort
                    .findByBookableUnitId(bookableUnit.getId())
                    .orElseThrow(() -> new EntityNotFoundException(HotelRoomDetails.class, bookableUnitId));
            case GUEST_ROOM -> guestHouseRoomDetailsRepositoryPort
                    .findByBookableUnitId(bookableUnit.getId())
                    .orElseThrow(() -> new EntityNotFoundException(GuestRoomDetails.class, bookableUnitId));
            case COTTAGE -> cottageDetailsRepositoryPort
                    .findByBookableUnitId(bookableUnit.getId())
                    .orElseThrow(() -> new EntityNotFoundException(CottageDetails.class, bookableUnitId));
            //case CAMPING -> dopisać
            default ->
                    throw new IllegalArgumentException("Unrecognized bookableUnitType: " + bookableUnit.getBookableUnitType());
        };

        return new BookableUnitSummary(bookableUnit, details);
    }
}

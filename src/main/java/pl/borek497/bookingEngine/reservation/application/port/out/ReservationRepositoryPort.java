package pl.borek497.bookingEngine.reservation.application.port.out;

import pl.borek497.bookingEngine.reservation.domain.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface ReservationRepositoryPort {

    Reservation save(Reservation reservation);
    boolean existsOverlappingReservation(
            Long bookableUnitId,
            LocalDate startDate,
            LocalDate endDate
    );
    Optional<Reservation> findById(Long id);
    List<Reservation> findByCustomerId(Long customerId);
}

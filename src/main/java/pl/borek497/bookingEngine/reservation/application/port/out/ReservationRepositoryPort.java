package pl.borek497.bookingEngine.reservation.application.port.out;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.reservation.application.command.CreateReservationCommand;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

@Component
public interface ReservationRepositoryPort {

    Reservation save(Reservation reservation);
    boolean existsOverlappingReservation(CreateReservationCommand command);
}

package pl.borek497.bookingEngine.reservation.application.port.in;

import pl.borek497.bookingEngine.reservation.application.command.CreateReservationCommand;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

public interface ReservationUseCase {

    Reservation createReservation(CreateReservationCommand command);
}

package pl.borek497.bookingEngine.reservation.application.port.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import pl.borek497.bookingEngine.reservation.application.ReservationDetails;
import pl.borek497.bookingEngine.reservation.application.command.CreateReservationCommand;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

import java.util.List;

public interface ReservationUseCase {

    Reservation createReservation(CreateReservationCommand command);
    ReservationDetails getDetailsById(@NotNull @Positive Long reservationId);
    List<Reservation> getByCustomerId(@NotNull @Positive Long customerId);
}

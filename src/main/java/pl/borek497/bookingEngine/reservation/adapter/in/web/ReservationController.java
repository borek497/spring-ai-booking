package pl.borek497.bookingEngine.reservation.adapter.in.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.borek497.bookingEngine.reservation.application.command.CreateReservationCommand;
import pl.borek497.bookingEngine.reservation.application.port.in.ReservationUseCase;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

import java.net.URI;

import static pl.borek497.bookingEngine.common.adapter.in.web.ResourceUriFactory.forCreatedResource;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
class ReservationController {

    private final ReservationUseCase reservationUseCase;

    @PostMapping
    public ResponseEntity<Void> createReservation(@Valid @RequestBody CreateReservationCommand command) {
        Reservation reservation = reservationUseCase.createReservation(command);
        URI uri = forCreatedResource(reservation.getId());
        return ResponseEntity.created(uri).build();
    }
}

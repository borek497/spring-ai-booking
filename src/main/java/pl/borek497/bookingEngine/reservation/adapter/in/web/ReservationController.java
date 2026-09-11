package pl.borek497.bookingEngine.reservation.adapter.in.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.borek497.bookingEngine.reservation.application.command.CreateReservationCommand;
import pl.borek497.bookingEngine.reservation.application.port.in.ReservationUseCase;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

import java.net.URI;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
class ReservationController {

    private final ReservationUseCase reservationUseCase;

    @PostMapping
    public ResponseEntity<Void> createReservation(@Valid @RequestBody CreateReservationCommand command) {
        Reservation reservation = reservationUseCase.createReservation(command);
        URI uri = createReservationUri(reservation);
        return ResponseEntity.created(uri).build();
    }

    private static URI createReservationUri(Reservation reservation) {
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(reservation.getId())
                .toUri();
    }
}

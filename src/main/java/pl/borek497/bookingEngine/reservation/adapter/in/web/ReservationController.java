package pl.borek497.bookingEngine.reservation.adapter.in.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.borek497.bookingEngine.reservation.application.command.CreateReservationCommand;
import pl.borek497.bookingEngine.reservation.application.port.in.ReservationUseCase;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{id}")
    public ReservationDetailsResponse getReservationDetailsById(@PathVariable Long id) {
        return ReservationDetailsResponse.fromModel(reservationUseCase.getDetailsById(id));
    }

    @GetMapping
    public List<ReservationResponse> getReservationsForCustomer(@RequestParam Long customerId) {
        return reservationUseCase
                .getByCustomerId(customerId)
                .stream()
                .map(ReservationResponse::fromModel)
                .toList();
    }
}

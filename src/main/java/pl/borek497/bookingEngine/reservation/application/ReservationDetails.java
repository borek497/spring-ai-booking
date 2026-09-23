package pl.borek497.bookingEngine.reservation.application;

import pl.borek497.bookingEngine.customer.domain.Customer;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

public record ReservationDetails(
        Reservation reservation,
        Customer customer
) {
}

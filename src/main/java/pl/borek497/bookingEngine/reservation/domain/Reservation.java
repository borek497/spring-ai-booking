package pl.borek497.bookingEngine.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Reservation {
    //obiekt będzie można zmieniać, np user zmieni daty rezerwacji, status etc.

    private Long id;
    private Long bookableUnitId;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus reservationStatus;
    private BigDecimal totalPrice;
    private Long userId;
    private int guestsNumber;
}

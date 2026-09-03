package pl.borek497.bookingEngine.property.domain.model;

import pl.borek497.bookingEngine.reservation.domain.model.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {

    private Long id;
    private Long bookableUnitId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int guestCount;
    private ReservationStatus status;
    private BigDecimal totalPrice;
}

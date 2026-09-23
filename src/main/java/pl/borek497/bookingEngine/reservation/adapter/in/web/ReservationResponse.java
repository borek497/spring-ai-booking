package pl.borek497.bookingEngine.reservation.adapter.in.web;

import pl.borek497.bookingEngine.reservation.domain.Reservation;
import pl.borek497.bookingEngine.reservation.domain.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservationResponse(
        Long id,
        Long bookableUnitId,
        LocalDate startDate,
        LocalDate endDate,
        ReservationStatus reservationStatus,
        BigDecimal totalPrice,
        Long customerId,
        int guestsNumber
) {

    public static ReservationResponse fromModel(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId(),
                reservation.getBookableUnitId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getReservationStatus(),
                reservation.getTotalPrice(),
                reservation.getCustomerId(),
                reservation.getGuestsNumber()
        );
    }
}

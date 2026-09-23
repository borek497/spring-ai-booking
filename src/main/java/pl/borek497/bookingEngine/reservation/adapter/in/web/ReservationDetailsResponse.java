package pl.borek497.bookingEngine.reservation.adapter.in.web;

import pl.borek497.bookingEngine.customer.adapter.in.web.CustomerResponse;
import pl.borek497.bookingEngine.reservation.application.ReservationDetails;
import pl.borek497.bookingEngine.reservation.domain.Reservation;
import pl.borek497.bookingEngine.reservation.domain.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservationDetailsResponse(
        Long id,
        Long bookableUnitId,
        LocalDate startDate,
        LocalDate endDate,
        ReservationStatus reservationStatus,
        BigDecimal totalPrice,
        int guestsNumber,
        CustomerResponse

        customer
) {
    public static ReservationDetailsResponse fromModel(ReservationDetails reservationDetails) {
        Reservation reservation = reservationDetails.reservation();

        return new ReservationDetailsResponse(
                reservation.getId(),
                reservation.getBookableUnitId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getReservationStatus(),
                reservation.getTotalPrice(),
                reservation.getGuestsNumber(),
                CustomerResponse.fromModel(reservationDetails.customer())
        );
    }
}

package pl.borek497.bookingEngine.reservation.domain.model;

public enum ReservationStatus {
    NEW,
    WAITING_FOR_CONFIRMATION,
    CONFIRMED,
    PAID,
    ABANDONED,
    CANCELED
}

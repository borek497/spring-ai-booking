package pl.borek497.bookingEngine.bookableUnit.domain;

import pl.borek497.bookingEngine.property.domain.Status;

import java.math.BigDecimal;

public record Room(
        Long bookableUnitId,
        Long propertyId,
        String roomNumber,
        RoomCategory roomCategory,
        int maxGuests,
        BigDecimal basePricePerNight,
        Status status) {
}

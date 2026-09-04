package pl.borek497.bookingEngine.bookableUnit.domain;

import pl.borek497.bookingEngine.property.domain.RoomCategory;
import pl.borek497.bookingEngine.property.domain.model.Status;

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

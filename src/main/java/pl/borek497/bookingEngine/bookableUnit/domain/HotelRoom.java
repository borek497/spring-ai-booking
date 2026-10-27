package pl.borek497.bookingEngine.bookableUnit.domain;

import pl.borek497.bookingEngine.property.domain.Status;

import java.math.BigDecimal;

public record HotelRoom(
        Long bookableUnitId,
        Long propertyId,
        String roomNumber,
        HotelRoomCategory hotelRoomCategory,
        int maxGuests,
        BigDecimal basePricePerNight,
        Status status) {
}

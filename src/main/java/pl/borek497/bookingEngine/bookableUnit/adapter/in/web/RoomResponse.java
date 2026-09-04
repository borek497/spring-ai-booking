package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import pl.borek497.bookingEngine.bookableUnit.domain.Room;
import pl.borek497.bookingEngine.property.domain.RoomCategory;
import pl.borek497.bookingEngine.property.domain.model.Status;

import java.math.BigDecimal;

public record RoomResponse(
        Long bookableUnitId,
        Long propertyId,
        String roomNumber,
        RoomCategory roomCategory,
        int maxGuests,
        BigDecimal basePricePerNight,
        Status status
) {

    public static RoomResponse from(Room room) {
        return new RoomResponse(
                room.bookableUnitId(),
                room.propertyId(),
                room.roomNumber(),
                room.roomCategory(),
                room.maxGuests(),
                room.basePricePerNight(),
                room.status()
        );
    }
}

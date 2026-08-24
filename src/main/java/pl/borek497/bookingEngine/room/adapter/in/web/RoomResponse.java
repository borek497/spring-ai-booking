package pl.borek497.bookingEngine.room.adapter.in.web;

import pl.borek497.bookingEngine.room.domain.Room;
import pl.borek497.bookingEngine.room.domain.RoomStatus;

import java.math.BigDecimal;

public record RoomResponse(
        Long id,
        Long propertyId,
        String roomNumber,
        int capacity,
        boolean privateKitchen,
        boolean privateBathroom,
        String additionalInfo,
        RoomStatus roomStatus,
        BigDecimal pricePerNight
) {

    public static RoomResponse from(Room room) {
        return new RoomResponse(
                room.getId(),
                room.getPropertyId(),
                room.getRoomNumber(),
                room.getCapacity(),
                room.isPrivateKitchen(),
                room.isPrivateBathroom(),
                room.getAdditionalInfo(),
                room.getRoomStatus(),
                room.getPricePerNight()
        );
    }
}

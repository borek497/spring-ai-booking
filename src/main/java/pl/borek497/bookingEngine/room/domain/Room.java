package pl.borek497.bookingEngine.room.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
//wybieram klasę aby mieć furtkę do modyfikacji modelu (np. zmiana capacity)
public class Room {

    private final Long id;
    private final Long propertyId;
    private final String roomNumber;
    private final int capacity;
    private final boolean isPrivateKitchen;
    private final boolean isPrivateBathroom;
    private final String additionalInfo;
    private final RoomStatus roomStatus;
    private final BigDecimal pricePerNight;

    public Room(
            Long id,
            Long propertyId,
            String roomNumber,
            int capacity,
            boolean isPrivateKitchen,
            boolean isPrivateBathroom,
            String additionalInfo,
            RoomStatus roomStatus, BigDecimal pricePerNight
    ) {
        this.id = id;
        this.propertyId = propertyId;
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
        this.pricePerNight = pricePerNight;
        if (capacity <= 0) {
            throw new IllegalArgumentException("Room capacity must be grater than 0");
        }
        this.capacity = capacity;
        this.isPrivateKitchen = isPrivateKitchen;
        this.isPrivateBathroom = isPrivateBathroom;
        this.additionalInfo = additionalInfo;
    }
}

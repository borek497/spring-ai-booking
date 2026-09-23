package pl.borek497.bookingEngine.property.domain.model.bookableType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

@Getter
@AllArgsConstructor
public class HotelRoomDetails {

    private Long bookableUnitId;
    private String roomNumber;
    private RoomCategory roomCategory;
}

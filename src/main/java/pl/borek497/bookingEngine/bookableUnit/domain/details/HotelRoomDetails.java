package pl.borek497.bookingEngine.bookableUnit.domain.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.borek497.bookingEngine.bookableUnit.domain.RoomCategory;

@Getter
@AllArgsConstructor
public class HotelRoomDetails {

    private Long bookableUnitId;
    private String roomNumber;
    private RoomCategory roomCategory;
}

package pl.borek497.bookingEngine.bookableUnit.domain.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;

@Getter
@AllArgsConstructor
public class HotelRoomDetails implements BookableUnitDetails {

    private Long bookableUnitId;
    private String roomNumber;
    private HotelRoomCategory hotelRoomCategory;
}

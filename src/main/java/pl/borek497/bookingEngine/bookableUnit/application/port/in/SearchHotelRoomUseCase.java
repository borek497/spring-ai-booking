package pl.borek497.bookingEngine.bookableUnit.application.port.in;

import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoom;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;

import java.util.List;

public interface SearchHotelRoomUseCase {

    List<HotelRoom> findRoomsByPropertyIdAndRoomCategory(Long propertyId, HotelRoomCategory hotelRoomCategory);
}

package pl.borek497.bookingEngine.bookableUnit.application.port.out;

import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoom;

import java.util.List;

public interface SearchRoomsRepositoryPort {

    List<HotelRoom> findByPropertyIdAndRoomCategory(Long propertyId, HotelRoomCategory hotelRoomCategory);
}

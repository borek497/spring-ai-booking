package pl.borek497.bookingEngine.bookableUnit.application.port.in;

import pl.borek497.bookingEngine.bookableUnit.domain.Room;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

import java.util.List;

public interface SearchRoomsUseCase {

    List<Room> findRoomsByPropertyIdAndRoomCategory(Long propertyId, RoomCategory roomCategory);
}

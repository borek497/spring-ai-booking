package pl.borek497.bookingEngine.bookableUnit.application.port.out;

import pl.borek497.bookingEngine.bookableUnit.domain.Room;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

import java.util.List;

public interface SearchRoomsRepositoryPort {

    List<Room> findByPropertyIdAndRoomCategory(Long propertyId, RoomCategory roomCategory);
}

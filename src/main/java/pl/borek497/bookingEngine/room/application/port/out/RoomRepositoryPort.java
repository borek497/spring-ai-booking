package pl.borek497.bookingEngine.room.application.port.out;

import pl.borek497.bookingEngine.room.domain.Room;

import java.util.List;

public interface RoomRepositoryPort {

    List<Room> findByPropertyId(Long propertyId);
    List<Room> findAvailableByPropertyId(Long id);
    List<Room> findByCity(String city);
}

package pl.borek497.bookingEngine.room.application.port.in;

import pl.borek497.bookingEngine.room.domain.Room;

import java.util.List;

public interface RoomUseCase {

    List<Room> findByPropertyId(Long id);
    List<Room> findAvailableByPropertyId(Long id);
    List<Room> findByCity(String city);
}

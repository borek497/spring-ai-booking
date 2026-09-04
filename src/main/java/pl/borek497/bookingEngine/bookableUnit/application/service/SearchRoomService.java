package pl.borek497.bookingEngine.bookableUnit.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.SearchRoomsUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.SearchRoomsRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.Room;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

import java.util.List;

@Service
@AllArgsConstructor
class SearchRoomService implements SearchRoomsUseCase {

    private final SearchRoomsRepositoryPort searchRoomsRepositoryPort;

    @Override
    public List<Room> findRoomsByPropertyIdAndRoomCategory(Long propertyId, RoomCategory roomCategory) {
        return searchRoomsRepositoryPort.findByPropertyIdAndRoomCategory(propertyId, roomCategory);
    }
}

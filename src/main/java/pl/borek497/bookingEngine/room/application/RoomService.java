package pl.borek497.bookingEngine.room.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.borek497.bookingEngine.room.application.port.in.RoomUseCase;
import pl.borek497.bookingEngine.room.application.port.out.RoomRepositoryPort;
import pl.borek497.bookingEngine.room.domain.Room;

import java.util.List;

@Service
@AllArgsConstructor
class RoomService implements RoomUseCase {

    private final RoomRepositoryPort repositoryPort;

    @Override
    public List<Room> findByPropertyId(Long id) {
        return repositoryPort.findByPropertyId(id);
    }

    @Override
    public List<Room> findAvailableByPropertyId(Long id) {
        return repositoryPort.findAvailableByPropertyId(id);
    }

    @Override
    public List<Room> findByCity(String city) {
        return List.of();
    }
}

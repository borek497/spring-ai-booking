package pl.borek497.bookingEngine.room.adapter.out.persistance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.room.application.port.out.RoomRepositoryPort;
import pl.borek497.bookingEngine.room.domain.Room;
import pl.borek497.bookingEngine.room.domain.RoomStatus;

import java.util.List;

@AllArgsConstructor
@Repository
public class RoomRepositoryAdapter implements RoomRepositoryPort {

    private final RoomJpaRepository repository;
    private final RoomPersistenceMapper mapper;

    @Override
    public List<Room> findByPropertyId(Long propertyId) {
        return repository
                .findByPropertyId(propertyId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Room> findAvailableByPropertyId(Long id) {
        return repository
                .findByPropertyIdAndRoomStatus(id, RoomStatus.AVAILABLE)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Room> findByCity(String city) {
        return List.of();
    }
}

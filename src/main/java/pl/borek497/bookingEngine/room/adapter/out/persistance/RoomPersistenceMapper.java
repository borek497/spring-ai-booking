package pl.borek497.bookingEngine.room.adapter.out.persistance;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.room.domain.Room;

@Component
public class RoomPersistenceMapper {

    public Room toDomain(RoomEntity entity) {
        return new Room(
                entity.getId(),
                entity.getProperty().getId(),
                entity.getRoomNumber(),
                entity.getCapacity(),
                entity.isPrivateKitchen(),
                entity.isPrivateBathroom(),
                entity.getAdditionalInfo(),
                entity.getRoomStatus(),
                entity.getPricePerNight()
        );
    }
}

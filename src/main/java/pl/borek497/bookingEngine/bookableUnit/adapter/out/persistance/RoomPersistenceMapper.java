package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.bookableUnit.domain.Room;
import pl.borek497.bookingEngine.property.adapter.out.persistence.RoomDetailsEntity;

@Component
public class RoomPersistenceMapper {

    public Room toRoom(RoomDetailsEntity roomDetailsEntity) {
        BookableUnitEntity unit = roomDetailsEntity.getBookableUnit();

        return new Room(
                unit.getId(),
                unit.getProperty().getId(),
                roomDetailsEntity.getRoomNumber(),
                roomDetailsEntity.getRoomCategory(),
                unit.getMaxGuests(),
                unit.getBasePricePerNight(),
                unit.getStatus()
        );
    }
}

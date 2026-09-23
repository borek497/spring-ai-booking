package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.bookableUnit.domain.Room;
import pl.borek497.bookingEngine.property.adapter.out.persistence.HotelRoomDetailsEntity;

@Component
public class RoomPersistenceMapper {

    public Room toRoom(HotelRoomDetailsEntity hotelRoomDetailsEntity) {
        BookableUnitEntity unit = hotelRoomDetailsEntity.getBookableUnit();

        return new Room(
                unit.getId(),
                unit.getProperty().getId(),
                hotelRoomDetailsEntity.getRoomNumber(),
                hotelRoomDetailsEntity.getRoomCategory(),
                unit.getMaxGuests(),
                unit.getBasePricePerNight(),
                unit.getStatus()
        );
    }
}

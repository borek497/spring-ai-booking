package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.hotelroom;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.BookableUnitEntity;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoom;

@Component
public class HotelRoomPersistenceMapper {

    public HotelRoom toRoom(HotelRoomDetailsEntity hotelRoomDetailsEntity) {
        BookableUnitEntity unit = hotelRoomDetailsEntity.getBookableUnit();

        return new HotelRoom(
                unit.getId(),
                unit.getProperty().getId(),
                hotelRoomDetailsEntity.getHotelRoomNumber(),
                hotelRoomDetailsEntity.getHotelRoomCategory(),
                unit.getMaxGuests(),
                unit.getBasePricePerNight(),
                unit.getStatus()
        );
    }
}

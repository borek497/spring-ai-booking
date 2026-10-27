package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.hotelroom;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.bookableUnit.domain.details.HotelRoomDetails;

@Component
public class HotelRoomDetailsMapper {

    public HotelRoomDetails toDomain(HotelRoomDetailsEntity entity) {
        return new HotelRoomDetails(
                entity.getBookableUnit().getId(),
                entity.getHotelRoomNumber(),
                entity.getHotelRoomCategory()
        );
    }
}

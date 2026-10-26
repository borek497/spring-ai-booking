package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.guestroom;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.bookableUnit.domain.details.GuestRoomDetails;

@Component
public class GuestRoomDetailsMapper {

    public GuestRoomDetails toDomain(GuestRoomDetailsEntity entity) {
        return new GuestRoomDetails(
                entity.getBookableUnit().getId(),
                entity.getRoomNumber(),
                entity.isPrivateBathroom()
        );
    }
}

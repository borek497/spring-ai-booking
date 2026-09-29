package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.property.adapter.out.persistence.ApartmentDetailsEntity;
import pl.borek497.bookingEngine.property.domain.model.bookableType.ApartmentDetails;
import pl.borek497.bookingEngine.property.domain.model.bookableType.ApartmentRoomDetails;

import java.util.List;

@Component
public class ApartmentDetailsMapper {

    public ApartmentDetails toDomain(ApartmentDetailsEntity entity) {
        return new ApartmentDetails(
                entity.getBookableUnit().getId(),
                entity.getName(),
                convert(entity),
                entity.isPrivateBathroom(),
                entity.isPrivateKitchen()
        );
    }

    private List<ApartmentRoomDetails> convert(ApartmentDetailsEntity apartmentEntity) {
        return apartmentEntity.getRooms()
                .stream()
                .map(room -> new ApartmentRoomDetails(
                        room.getId(),
                        room.getCapacity()
                ))
                .toList();
    }
}

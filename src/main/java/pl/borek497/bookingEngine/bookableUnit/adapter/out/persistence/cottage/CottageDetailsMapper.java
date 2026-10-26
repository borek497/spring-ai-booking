package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.cottage;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.bookableUnit.domain.details.CottageDetails;

@Component
public class CottageDetailsMapper {

    public CottageDetails toDomain(CottageDetailsEntity entity) {
        return new CottageDetails(
                entity.getBookableUnit().getId(),
                entity.getName(),
                entity.getRoomCount(),
                entity.isPrivateBathroom(),
                entity.isPrivateKitchen()
        );
    }
}

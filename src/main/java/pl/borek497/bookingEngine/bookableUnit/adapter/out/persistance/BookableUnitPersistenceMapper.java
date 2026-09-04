package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;

@Component
public class BookableUnitPersistenceMapper {

    public BookableUnit toDomain(BookableUnitEntity entity) {
        return new BookableUnit(
                entity.getId(),
                entity.getProperty().getId(),
                entity.getBookableUnitType(),
                entity.getMaxGuests(),
                entity.getBasePricePerNight(),
                entity.getStatus()
        );
    }
}

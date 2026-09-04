package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borek497.bookingEngine.property.adapter.out.persistence.RoomDetailsEntity;
import pl.borek497.bookingEngine.property.domain.RoomCategory;
import pl.borek497.bookingEngine.property.domain.model.Status;

import java.util.List;

public interface SearchRoomJpaRepository extends JpaRepository<RoomDetailsEntity, Long> {

    List<RoomDetailsEntity> findByBookableUnitPropertyIdAndRoomCategoryAndBookableUnitStatus(
            Long bookableUnitPropertyId,
            RoomCategory roomCategory,
            Status bookableUnitStatus
    );
}

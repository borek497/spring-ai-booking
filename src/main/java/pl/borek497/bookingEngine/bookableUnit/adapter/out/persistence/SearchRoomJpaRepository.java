package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borek497.bookingEngine.bookableUnit.domain.RoomCategory;
import pl.borek497.bookingEngine.property.domain.Status;

import java.util.List;

public interface SearchRoomJpaRepository extends JpaRepository<HotelRoomDetailsEntity, Long> {

    List<HotelRoomDetailsEntity> findByBookableUnitPropertyIdAndRoomCategoryAndBookableUnitStatus(
            Long bookableUnitPropertyId,
            RoomCategory roomCategory,
            Status bookableUnitStatus
    );

    boolean existsByPropertyIdAndRoomNumber(Long propertyId, String roomNumber);
}

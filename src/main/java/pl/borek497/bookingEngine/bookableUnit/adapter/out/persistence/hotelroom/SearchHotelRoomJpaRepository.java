package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.hotelroom;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;
import pl.borek497.bookingEngine.property.domain.Status;

import java.util.List;

public interface SearchHotelRoomJpaRepository extends JpaRepository<HotelRoomDetailsEntity, Long> {

    List<HotelRoomDetailsEntity> findByBookableUnitPropertyIdAndHotelRoomCategoryAndBookableUnitStatus(
            Long bookableUnitPropertyId,
            HotelRoomCategory hotelRoomCategory,
            Status bookableUnitStatus
    );
}

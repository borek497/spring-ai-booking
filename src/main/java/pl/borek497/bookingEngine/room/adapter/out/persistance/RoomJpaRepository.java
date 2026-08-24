package pl.borek497.bookingEngine.room.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borek497.bookingEngine.room.domain.RoomStatus;

import java.util.List;

public interface RoomJpaRepository extends JpaRepository<RoomEntity, Long> {

    List<RoomEntity> findByPropertyId(Long propertyId);
    List<RoomEntity> findByPropertyIdAndRoomStatus(Long propertyId, RoomStatus roomStatus);
}

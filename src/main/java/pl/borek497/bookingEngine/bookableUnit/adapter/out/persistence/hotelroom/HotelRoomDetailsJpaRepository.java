package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.hotelroom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRoomDetailsJpaRepository extends JpaRepository<HotelRoomDetailsEntity, Long> {

    Optional<HotelRoomDetailsEntity> findByBookableUnit_Id(Long bookableUnitId);
}

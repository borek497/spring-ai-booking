package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.guestroom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRoomDetailsJpaRepository extends JpaRepository<GuestRoomDetailsEntity, Long> {

    Optional<GuestRoomDetailsEntity> findByBookableUnit_Id(Long bookableUnitId);
}

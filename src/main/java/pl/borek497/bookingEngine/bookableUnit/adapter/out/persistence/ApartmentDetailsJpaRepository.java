package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApartmentDetailsJpaRepository extends JpaRepository<ApartmentDetailsEntity, Long> {

    Optional<ApartmentDetailsEntity> findByBookableUnit_Id(Long bookableUnitId);
}

package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.cottage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CottageDetailsJpaRepository extends JpaRepository<CottageDetailsEntity, Long> {

    Optional<CottageDetailsEntity> findByBookableUnit_Id(Long bookableUnitId);
}

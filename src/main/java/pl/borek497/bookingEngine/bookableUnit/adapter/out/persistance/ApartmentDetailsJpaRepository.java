package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borek497.bookingEngine.property.adapter.out.persistence.ApartmentDetailsEntity;

import java.util.Optional;

public interface ApartmentDetailsJpaRepository extends JpaRepository<ApartmentDetailsEntity, Long> {

    Optional<ApartmentDetailsEntity> findByBookableUnit_Id(Long bookableUnitId);
}

package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookableUnitJpaRepository extends JpaRepository<BookableUnitEntity, Long> {

    List<BookableUnitEntity> findByPropertyId(Long propertyId);
}

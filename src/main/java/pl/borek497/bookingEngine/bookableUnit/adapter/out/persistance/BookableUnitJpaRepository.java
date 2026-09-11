package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookableUnitJpaRepository extends JpaRepository<BookableUnitEntity, Long> {

    List<BookableUnitEntity> findByPropertyId(Long propertyId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select b from BookableUnitEntity b where b.id = :id")
    Optional<BookableUnitEntity> findByIdForUpdate(@Param("id") Long id);
}

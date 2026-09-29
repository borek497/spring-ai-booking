package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.ApartmentDetailsRepositoryPort;
import pl.borek497.bookingEngine.property.domain.model.bookableType.ApartmentDetails;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ApartmentDetailsRepositoryAdapter implements ApartmentDetailsRepositoryPort {

    private final ApartmentDetailsJpaRepository repository;
    private final ApartmentDetailsMapper mapper;

    @Override
    public Optional<ApartmentDetails> findByBookableUnitId(Long bookableUnitId) {
        return repository
                .findByBookableUnit_Id(bookableUnitId)
                .map(mapper::toDomain);
    }
}

package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.cottage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.CottageDetailsRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.details.CottageDetails;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CottageDetailsRepositoryAdapter implements CottageDetailsRepositoryPort {

    private final CottageDetailsJpaRepository jpaRepository;
    private final CottageDetailsMapper mapper;

    @Override
    public Optional<CottageDetails> findByBookableUnitId(Long bookableUnitId) {
        return jpaRepository
                .findByBookableUnit_Id(bookableUnitId)
                .map(mapper::toDomain);
    }
}

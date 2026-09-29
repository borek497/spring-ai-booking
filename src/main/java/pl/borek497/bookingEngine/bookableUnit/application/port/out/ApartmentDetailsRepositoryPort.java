package pl.borek497.bookingEngine.bookableUnit.application.port.out;

import pl.borek497.bookingEngine.bookableUnit.domain.details.ApartmentDetails;

import java.util.Optional;

public interface ApartmentDetailsRepositoryPort {

    Optional<ApartmentDetails> findByBookableUnitId(Long bookableUnitId);
}

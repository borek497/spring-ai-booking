package pl.borek497.bookingEngine.bookableUnit.application.port.out;

import pl.borek497.bookingEngine.property.domain.model.bookableType.ApartmentDetails;

import java.util.Optional;

public interface ApartmentDetailsRepositoryPort {

    Optional<ApartmentDetails> findByBookableUnitId(Long bookableUnitId);
}

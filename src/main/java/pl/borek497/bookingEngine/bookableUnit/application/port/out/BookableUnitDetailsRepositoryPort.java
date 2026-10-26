package pl.borek497.bookingEngine.bookableUnit.application.port.out;

import java.util.Optional;

public interface BookableUnitDetailsRepositoryPort<T> {

    Optional<T> findByBookableUnitId(Long bookableUnitId);
}

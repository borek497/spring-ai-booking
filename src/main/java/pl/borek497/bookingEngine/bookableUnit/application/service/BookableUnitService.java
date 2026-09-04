package pl.borek497.bookingEngine.bookableUnit.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.BookableUnitUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.BookableUnitRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.exceptions.EntityNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
class BookableUnitService implements BookableUnitUseCase {

    private BookableUnitRepositoryPort repository;

    @Override
    public BookableUnit getById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(BookableUnit.class, id));
    }

    @Override
    public List<BookableUnit> getByPropertyId(Long propertyId) {
        return repository.findByPropertyId(propertyId);
    }
}

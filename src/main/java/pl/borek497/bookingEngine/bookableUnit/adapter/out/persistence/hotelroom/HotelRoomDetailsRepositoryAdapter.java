package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.hotelroom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.HotelRoomDetailsRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.details.HotelRoomDetails;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HotelRoomDetailsRepositoryAdapter implements HotelRoomDetailsRepositoryPort {

    private final HotelRoomDetailsJpaRepository repository;
    private final HotelRoomDetailsMapper mapper;

    @Override
    public Optional<HotelRoomDetails> findByBookableUnitId(Long bookableUnitId) {
        return repository
                .findByBookableUnit_Id(bookableUnitId)
                .map(mapper::toDomain);
    }
}

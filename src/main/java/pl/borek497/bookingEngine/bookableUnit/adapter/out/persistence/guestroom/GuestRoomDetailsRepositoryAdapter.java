package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.guestroom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.GuestHouseRoomDetailsRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.details.GuestRoomDetails;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GuestRoomDetailsRepositoryAdapter implements GuestHouseRoomDetailsRepositoryPort {

    private final GuestRoomDetailsJpaRepository repository;
    private final GuestRoomDetailsMapper mapper;

    @Override
    public Optional<GuestRoomDetails> findByBookableUnitId(Long bookableUnitId) {
        return repository
                .findByBookableUnit_Id(bookableUnitId)
                .map(mapper::toDomain);
    }
}

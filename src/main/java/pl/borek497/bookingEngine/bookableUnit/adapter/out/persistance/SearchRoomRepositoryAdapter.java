package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.SearchRoomsRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.Room;
import pl.borek497.bookingEngine.property.domain.RoomCategory;
import pl.borek497.bookingEngine.property.domain.model.Status;

import java.util.List;

@Repository
@AllArgsConstructor
class SearchRoomRepositoryAdapter implements SearchRoomsRepositoryPort {

    private final SearchRoomJpaRepository searchRoomJpaRepository;
    private final RoomPersistenceMapper mapper;

    @Override
    public List<Room> findByPropertyIdAndRoomCategory(Long propertyId, RoomCategory roomCategory) {
        return searchRoomJpaRepository
                .findByBookableUnitPropertyIdAndRoomCategoryAndBookableUnitStatus(
                        propertyId,
                        roomCategory,
                        Status.ACTIVE
                )
                .stream()
                .map(mapper::toRoom)
                .toList();
    }
}

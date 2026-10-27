package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.hotelroom;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.SearchRoomsRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoom;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;
import pl.borek497.bookingEngine.property.domain.Status;

import java.util.List;

@Repository
@AllArgsConstructor
class SearchRoomRepositoryAdapter implements SearchRoomsRepositoryPort {

    private final SearchHotelRoomJpaRepository searchHotelRoomJpaRepository;
    private final HotelRoomPersistenceMapper mapper;

    @Override
    public List<HotelRoom> findByPropertyIdAndRoomCategory(Long propertyId, HotelRoomCategory hotelRoomCategory) {
        return searchHotelRoomJpaRepository
                .findByBookableUnitPropertyIdAndHotelRoomCategoryAndBookableUnitStatus(
                        propertyId,
                        hotelRoomCategory,
                        Status.ACTIVE
                )
                .stream()
                .map(mapper::toRoom)
                .toList();
    }
}

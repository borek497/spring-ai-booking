package pl.borek497.bookingEngine.bookableUnit.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.SearchHotelRoomUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.SearchRoomsRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoom;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;

import java.util.List;

@Service
@AllArgsConstructor
class SearchRoomService implements SearchHotelRoomUseCase {

    private final SearchRoomsRepositoryPort searchRoomsRepositoryPort;

    @Override
    public List<HotelRoom> findRoomsByPropertyIdAndRoomCategory(Long propertyId, HotelRoomCategory hotelRoomCategory) {
        return searchRoomsRepositoryPort.findByPropertyIdAndRoomCategory(propertyId, hotelRoomCategory);
    }
}

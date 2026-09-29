package pl.borek497.bookingEngine.bookableUnit.application.port.out;

import pl.borek497.bookingEngine.property.domain.model.bookableType.ApartmentRoomDetails;
import pl.borek497.bookingEngine.property.domain.model.bookableType.CottageDetails;
import pl.borek497.bookingEngine.property.domain.model.bookableType.HotelRoomDetails;

import java.util.Optional;

public interface BookableUnitDetailsRepositoryPort {

    Optional<HotelRoomDetails> findRoomDetailsByBookableUnitId(Long bookableUnitId);
    Optional<ApartmentRoomDetails> findApartmentRoomDetailsByBookableUnitId(Long bookableUnitId);
    Optional<CottageDetails> findCottageDetailsByBookableUnitId(Long bookableUnitId);
}

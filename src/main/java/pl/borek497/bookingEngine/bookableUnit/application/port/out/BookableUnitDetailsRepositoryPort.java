package pl.borek497.bookingEngine.bookableUnit.application.port.out;

import pl.borek497.bookingEngine.bookableUnit.domain.details.ApartmentRoomDetails;
import pl.borek497.bookingEngine.bookableUnit.domain.details.CottageDetails;
import pl.borek497.bookingEngine.bookableUnit.domain.details.HotelRoomDetails;

import java.util.Optional;

public interface BookableUnitDetailsRepositoryPort {

    Optional<HotelRoomDetails> findRoomDetailsByBookableUnitId(Long bookableUnitId);
    Optional<ApartmentRoomDetails> findApartmentRoomDetailsByBookableUnitId(Long bookableUnitId);
    Optional<CottageDetails> findCottageDetailsByBookableUnitId(Long bookableUnitId);
}

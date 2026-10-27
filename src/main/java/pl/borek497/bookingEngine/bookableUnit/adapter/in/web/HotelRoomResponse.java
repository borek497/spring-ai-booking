package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoom;
import pl.borek497.bookingEngine.property.domain.Status;

import java.math.BigDecimal;

public record HotelRoomResponse(
        Long bookableUnitId,
        Long propertyId,
        String hotelRoomNumber,
        HotelRoomCategory hotelRoomCategory,
        int maxGuests,
        BigDecimal basePricePerNight,
        Status status
) {

    public static HotelRoomResponse from(HotelRoom hotelRoom) {
        return new HotelRoomResponse(
                hotelRoom.bookableUnitId(),
                hotelRoom.propertyId(),
                hotelRoom.roomNumber(),
                hotelRoom.hotelRoomCategory(),
                hotelRoom.maxGuests(),
                hotelRoom.basePricePerNight(),
                hotelRoom.status()
        );
    }
}

package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitSpecificDetails;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

public record GuestRoomDetailsResponse(String roomNumber,
                                       RoomCategory roomCategory
                                       ) implements BookableUnitSpecificDetails {
}

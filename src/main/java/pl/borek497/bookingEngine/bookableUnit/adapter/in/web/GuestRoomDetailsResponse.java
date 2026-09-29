package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import pl.borek497.bookingEngine.bookableUnit.domain.details.BookableUnitSpecificDetails;
import pl.borek497.bookingEngine.bookableUnit.domain.RoomCategory;

public record GuestRoomDetailsResponse(String roomNumber,
                                       RoomCategory roomCategory
                                       ) implements BookableUnitSpecificDetails {
}

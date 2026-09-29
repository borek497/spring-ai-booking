package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import pl.borek497.bookingEngine.bookableUnit.domain.details.BookableUnitSpecificDetails;

import java.util.List;

public record ApartmentDetailsResponse(String name,
                                       boolean privateBathroom,
                                       boolean privateKitchen,
                                       List<ApartmentRoomResponse> rooms
) implements BookableUnitSpecificDetails {
}

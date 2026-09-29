package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitSpecificDetails;

public record CottageDetailsResponse(String name,
                                     int roomCount,
                                     boolean privateBathroom,
                                     boolean privateKitchen) implements BookableUnitSpecificDetails {
}

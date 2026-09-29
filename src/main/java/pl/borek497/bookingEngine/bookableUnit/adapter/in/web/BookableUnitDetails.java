package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitSpecificDetails;

public record BookableUnitDetails(
        BookableUnit bookableUnit,
        BookableUnitSpecificDetails specificDetails
) {
}

package pl.borek497.bookingEngine.bookableUnit.application;

import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.bookableUnit.domain.details.BookableUnitSpecificDetails;

public record BookableUnitDetails(
        BookableUnit bookableUnit,
        BookableUnitSpecificDetails specificDetails
) {
}

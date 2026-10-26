package pl.borek497.bookingEngine.bookableUnit.application;

import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.bookableUnit.domain.details.BookableUnitDetails;

public record BookableUnitSummary(
        BookableUnit bookableUnit,
        BookableUnitDetails specificDetails
) {
}

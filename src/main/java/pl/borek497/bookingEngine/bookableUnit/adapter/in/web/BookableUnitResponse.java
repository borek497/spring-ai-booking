package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitType;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.property.domain.model.Status;

import java.math.BigDecimal;

public record BookableUnitResponse(
        Long id,
        Long propertyId,
        BookableUnitType bookableUnitType,
        int maxGuests,
        BigDecimal basePricePerNight,
        Status status
) {

    public static BookableUnitResponse from(BookableUnit bookableUnit) {
        return new BookableUnitResponse(
                bookableUnit.getId(),
                bookableUnit.getPropertyId(),
                bookableUnit.getBookableUnitType(),
                bookableUnit.getMaxGuests(),
                bookableUnit.getBasePricePerNight(),
                bookableUnit.getStatus()
        );
    }
}

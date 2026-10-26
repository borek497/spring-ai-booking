package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitType;
import pl.borek497.bookingEngine.property.domain.Status;

import java.math.BigDecimal;

/**
 * Base class for API responses containing common bookable unit data. Represents BookableUnitEntity as response.
 */
@AllArgsConstructor
@Getter
public class BookableUnitResponse {
    private final Long id;
    private final Long propertyId;
    private final BookableUnitType bookableUnitType;
    private final int maxGuests;
    private final BigDecimal basePricePerNight;
    private final Status status;

    public static BookableUnitResponse fromModel(BookableUnit bookableUnit) {
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

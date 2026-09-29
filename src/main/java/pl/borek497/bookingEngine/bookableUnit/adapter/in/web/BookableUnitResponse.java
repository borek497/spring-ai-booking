package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitType;
import pl.borek497.bookingEngine.property.domain.Status;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public abstract class BookableUnitResponse {
    private final Long id;
    private final Long propertyId;
    private final BookableUnitType bookableUnitType;
    private final int maxGuests;
    private final BigDecimal basePricePerNight;
    private final Status status;
}

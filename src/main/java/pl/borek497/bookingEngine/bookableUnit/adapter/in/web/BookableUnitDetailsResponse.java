package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import lombok.Getter;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSummary;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.bookableUnit.domain.details.BookableUnitDetails;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitType;
import pl.borek497.bookingEngine.property.domain.Status;

import java.math.BigDecimal;

public class BookableUnitDetailsResponse extends BookableUnitResponse {

    @Getter
    private final BookableUnitDetails details;

    public BookableUnitDetailsResponse(
            Long id,
            Long propertyId,
            BookableUnitType bookableUnitType,
            int maxGuests,
            BigDecimal basePricePerNight,
            Status status,
            BookableUnitDetails details
    ) {
        super(id, propertyId, bookableUnitType, maxGuests, basePricePerNight, status);
        this.details = details;
    }

    public static BookableUnitDetailsResponse fromModel(BookableUnitSummary model) {
        BookableUnit bookableUnit = model.bookableUnit();
        return new BookableUnitDetailsResponse(
                bookableUnit.getId(),
                bookableUnit.getPropertyId(),
                bookableUnit.getBookableUnitType(),
                bookableUnit.getMaxGuests(),
                bookableUnit.getBasePricePerNight(),
                bookableUnit.getStatus(),
                model.specificDetails()
        );
    }
}

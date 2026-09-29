package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import lombok.Getter;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitType;
import pl.borek497.bookingEngine.property.domain.model.Status;

import java.math.BigDecimal;

@Getter
public class BookableUnitSummaryResponse extends BookableUnitResponse {

    private BookableUnitSummaryResponse(
            Long id,
            Long propertyId,
            BookableUnitType bookableUnitType,
            int maxGuests,
            BigDecimal basePricePerNight,
            Status status) {
        super(id, propertyId, bookableUnitType, maxGuests, basePricePerNight, status);
    }

    public static BookableUnitSummaryResponse fromModel(BookableUnit bookableUnit) {
        return new BookableUnitSummaryResponse(
                bookableUnit.getId(),
                bookableUnit.getPropertyId(),
                bookableUnit.getBookableUnitType(),
                bookableUnit.getMaxGuests(),
                bookableUnit.getBasePricePerNight(),
                bookableUnit.getStatus()
        );
    }
}

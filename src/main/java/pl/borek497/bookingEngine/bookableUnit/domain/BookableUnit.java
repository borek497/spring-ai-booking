package pl.borek497.bookingEngine.bookableUnit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.borek497.bookingEngine.property.domain.model.Status;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class BookableUnit {

    private Long id;
    private Long propertyId;
    private BookableUnitType bookableUnitType;
    private int maxGuests;
    private BigDecimal basePricePerNight;
    private Status status;
}

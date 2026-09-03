package pl.borek497.bookingEngine.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class BookableUnit {

    private Long id;
    private Long propertyId;
    private String name;
    private String description;
    private BookableUnitType bookableUnitType;
    private int maxGuests;
    private BigDecimal basePricePerNight;
    private Status status;
}

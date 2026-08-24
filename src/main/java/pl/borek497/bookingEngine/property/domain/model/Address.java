package pl.borek497.bookingEngine.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Address {
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;
}

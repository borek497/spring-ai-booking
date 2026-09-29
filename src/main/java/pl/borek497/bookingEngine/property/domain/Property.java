package pl.borek497.bookingEngine.property.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Property {

    private Long id;
    private String name;
    private String description;
    private PropertyType propertyType;
    private Status status;
    private Province province;
    private Address address;
}

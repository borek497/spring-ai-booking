package pl.borek497.bookingEngine.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Property {

    private Long id;
    private String name;
    private String description;
    private PropertyType propertyType;
    private PropertyStatus propertyStatus;
    private Province province;
    private Address address;
}

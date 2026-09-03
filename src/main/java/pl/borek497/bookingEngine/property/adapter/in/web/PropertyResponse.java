package pl.borek497.bookingEngine.property.adapter.in.web;

import pl.borek497.bookingEngine.property.domain.model.*;

public record PropertyResponse(
        Long id,
        String name,
        String description,
        PropertyType propertyType,
        Status status,
        Province province,
        Address address
) {

    public static PropertyResponse from(Property property) {
        return new PropertyResponse(
                property.getId(),
                property.getName(),
                property.getDescription(),
                property.getPropertyType(),
                property.getStatus(),
                property.getProvince(),
                property.getAddress()
        );
    }
}
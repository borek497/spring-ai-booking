package pl.borek497.bookingEngine.property.application;

import pl.borek497.bookingEngine.property.domain.model.PropertyStatus;
import pl.borek497.bookingEngine.property.domain.model.PropertyType;
import pl.borek497.bookingEngine.property.domain.model.Province;

public record PropertySearchCriteria(
        Province province,
        String city,
        PropertyStatus propertyStatus,
        PropertyType propertyType
) {
}

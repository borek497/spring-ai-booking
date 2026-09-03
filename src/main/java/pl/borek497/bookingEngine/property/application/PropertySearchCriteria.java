package pl.borek497.bookingEngine.property.application;

import org.springframework.ai.tool.annotation.ToolParam;
import pl.borek497.bookingEngine.property.domain.model.Status;
import pl.borek497.bookingEngine.property.domain.model.PropertyType;
import pl.borek497.bookingEngine.property.domain.model.Province;

public record PropertySearchCriteria(
        @ToolParam(
                description = "City name, for example Warszawa or Zakopane",
                required = false
        ) String city,

        @ToolParam(
                description = "Province for example Lubuskie",
                required = false
        ) Province province,

        @ToolParam(
                description = "Type of property, for example HOTEL or APARTMENT",
                required = false
        )
        PropertyType propertyType,
        @ToolParam(
                description = "Property status. Set only when explicitly specified",
                required = false
        )
        Status status
) {
}

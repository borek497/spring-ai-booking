package pl.borek497.bookingEngine.property.application;

import jakarta.validation.constraints.Size;
import org.springframework.ai.tool.annotation.ToolParam;
import pl.borek497.bookingEngine.property.domain.Status;
import pl.borek497.bookingEngine.property.domain.PropertyType;
import pl.borek497.bookingEngine.property.domain.Province;

public record PropertySearchCriteria(
        @Size(min = 1, max = 30)
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

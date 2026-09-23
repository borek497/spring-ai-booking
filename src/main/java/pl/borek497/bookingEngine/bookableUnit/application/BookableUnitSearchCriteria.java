package pl.borek497.bookingEngine.bookableUnit.application;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.format.annotation.DateTimeFormat;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitType;

import java.time.LocalDate;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

public record BookableUnitSearchCriteria(
        @NotNull
        @Positive
        @ToolParam(
                description = "ID of the property to search within, obtained from property search results"
        ) Long propertyId,

        @NotNull
        @FutureOrPresent
        @DateTimeFormat(iso = DATE)
        @ToolParam(
                description = "Arrival date in yyyy-MM-dd format"
        )  LocalDate startDate,

        @NotNull
        @FutureOrPresent
        @DateTimeFormat(iso = DATE)
        @ToolParam(
                description = "Departure date in yyyy-MM-dd format, strictly after startDate. Excluded from the stay"
        ) LocalDate endDate,

        @NotNull @Positive
        @ToolParam(
                description = "Total number of guests that a single bookable unit must accommodate"
        ) Integer numberOfGuests,

        @NotNull
        @ToolParam(
                description = "Type of bookable unit to search for: ROOM, APARTMENT, COTTAGE, CARAVAN or CAMPING_AREA"
        )
        BookableUnitType bookableUnitType
        ) {
}

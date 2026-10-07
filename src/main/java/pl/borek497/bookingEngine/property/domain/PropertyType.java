package pl.borek497.bookingEngine.property.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PropertyType {
    HOTEL("Hotel"),
    GUEST_HOUSE("Pokoje gościnne"),
    APARTMENT("Apartament"),
    LAKE_COTTAGE("Domek nad jeziorem"),
    FARM_HOUSE("Agroturystyka"),
    MOUNTAIN_COTTAGE("Domek w górach"),
    FOREST_COTTAGE("Domek w lesie"),
    CAMPING("Kemping");

    private final String displayName;
}

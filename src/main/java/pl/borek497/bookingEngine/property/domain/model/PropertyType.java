package pl.borek497.bookingEngine.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PropertyType {
    HOTEL("Hotel"),
    GUEST_HOUSE("Pokoje gościnne"),
    APARTMENT("Apartament"),
    LAKE_HOUSE("Domek nad jeziorem"),
    FARM_HOUSE("Agroturystyka"),
    MOUNTAIN_HOUSE("Domek w górach"),
    FOREST_HOUSE("Domek w lesie"),
    CAMPING("Kemping");

    private final String displayName;
}

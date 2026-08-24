package pl.borek497.bookingEngine.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PropertyType {
    APARTMENT("Apartament"),
    HOTEL("Hotel"),
    LAKE_HOUSE("Domek nad jeziorem"),
    FARM_HOUSE("Agroturystyka"),
    ROOMS("Pokoje");

    private final String displayName;
}

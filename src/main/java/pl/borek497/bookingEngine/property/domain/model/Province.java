package pl.borek497.bookingEngine.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.borek497.bookingEngine.property.domain.exceptions.UnknownProvinceException;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Province {

    DOLNOSLASKIE(1L, "Dolnośląskie"),
    KUJAWSKO_POMORSKIE(2L, "Kujawsko-Pomorskie"),
    LUBELSKIE(3L, "Lubelskie"),
    LUBUSKIE(4L, "Lubuskie"),
    LODZKIE(5L, "Łódzkie"),
    MALOPOLSKIE(6L, "Małopolskie"),
    MAZOWIECKIE(7L, "Mazowieckie"),
    OPOLSKIE(8L, "Opolskie"),
    PODKARPACKIE(9L, "Podkarpackie"),
    PODLASKIE(10L, "Podlaskie"),
    POMORSKIE(11L, "Pomorskie"),
    SLASKIE(12L, "Śląskie"),
    SWIETOKRZYSKIE(13L, "Świętokrzyskie"),
    WARMINSKO_MAZURSKIE(14L, "Warmińsko-Mazurskie"),
    WIELKOPOLSKIE(15L, "Wielkopolskie"),
    ZACHODNIOPOMORSKIE(16L, "Zachodniopomorskie");

    private final Long id;
    private final String name;

    public static Province fromName(String name) {
        return Arrays.stream(Province.values())
                .filter(province -> province.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new UnknownProvinceException("Unknown province: " + name));
    }

    public static Province fromId(Long id) {
        return Arrays.stream(Province.values())
                .filter(province -> province.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UnknownProvinceException("No province found with id: " + id));
    }
}
package pl.borek497.bookingEngine.property.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoomCategory {
    GUEST_ROOM(""),
    STANDARD("pokój z łazienką o powierzchni 12-25m2"),
    SUPERIOR("pokój o podwyższonym standardzie z łazienką o powierzchni 25-35m2"),
    DELUXE("pokój premium z osobną sypialnią, łazienką i salonem o powierzchni 35-45m2"),
    FAMILY("pokój rodzinny z 1 pokojem, łązienką i dużym salonem o powierzchni 45-60m2"),
    SUITE("apartament hotelowy z 2 pokojami, łazienką, salonem i aneksem kuchennym o powierzchni do 90m2");

    private final String description;
}

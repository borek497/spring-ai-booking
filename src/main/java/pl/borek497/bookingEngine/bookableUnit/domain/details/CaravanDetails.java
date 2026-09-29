package pl.borek497.bookingEngine.bookableUnit.domain.details;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CaravanDetails {

    private Long bookableUnitId;
    private int capacity;
}

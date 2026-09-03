package pl.borek497.bookingEngine.property.domain.model.bookableType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CampingAreaDetails {

    private Long bookableUnitId;
    private int capacity;
}

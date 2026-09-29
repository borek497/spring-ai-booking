package pl.borek497.bookingEngine.bookableUnit.domain.details;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CottageDetails {

    private Long bookableUnitId;
    private String name;
    private String additionalData;
    private int capacity;
    private int roomCapacity;
    private boolean privateBathroom;
    private boolean privateKitchen;
}

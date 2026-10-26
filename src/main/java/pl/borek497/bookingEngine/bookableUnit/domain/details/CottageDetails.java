package pl.borek497.bookingEngine.bookableUnit.domain.details;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CottageDetails implements BookableUnitDetails {

    private Long bookableUnitId;
    private String name;
    private int roomCount;
    private boolean privateBathroom;
    private boolean privateKitchen;
}

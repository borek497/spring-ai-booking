package pl.borek497.bookingEngine.bookableUnit.domain.details;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ApartmentDetails implements BookableUnitSpecificDetails {

    private Long bookableUnitId;
    private String name;
    private List<ApartmentRoomDetails> rooms;
    private boolean privateBathroom;
    private boolean privateKitchen;
}

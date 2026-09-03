package pl.borek497.bookingEngine.property.domain.model.bookableType;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ApartmentDetails {

    private Long bookableUnitId;
    private String name;
    private List<ApartmentRoomDetails> rooms;
    private int totalCapacity;
    private boolean privateBathroom;
    private boolean privateKitchen;
}

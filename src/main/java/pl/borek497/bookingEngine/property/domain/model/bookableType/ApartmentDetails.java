package pl.borek497.bookingEngine.property.domain.model.bookableType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitSpecificDetails;

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

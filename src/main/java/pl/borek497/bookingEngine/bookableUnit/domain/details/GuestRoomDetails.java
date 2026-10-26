package pl.borek497.bookingEngine.bookableUnit.domain.details;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GuestRoomDetails implements BookableUnitDetails {

    private Long bookableUnitId;
    private String roomNumber;
    private boolean isPrivateBathroom;
}

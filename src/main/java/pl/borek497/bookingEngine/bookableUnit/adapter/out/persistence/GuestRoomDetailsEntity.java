package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.common.adapter.out.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "guest_room_details")
@Getter
public class GuestRoomDetailsEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bookable_unit_id",
            nullable = false,
            unique = true
    )
    private BookableUnitEntity bookableUnit;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "private_bathroom", nullable = false)
    private boolean isPrivateBathroom;
}

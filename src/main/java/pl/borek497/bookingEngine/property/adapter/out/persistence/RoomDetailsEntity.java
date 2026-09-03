package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.jpa.BaseEntity;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room_details")
@Getter
public class RoomDetailsEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bookable_unit_id",
            nullable = false,
            unique = true
    )
    private BookableUnitEntity bookableUnit;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_category", nullable = false)
    private RoomCategory roomCategory;
}

package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance.BookableUnitEntity;
import pl.borek497.bookingEngine.jpa.BaseEntity;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "hotel_room_details",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_room_details_property_room_number",
                columnNames = {"property_id", "room_number"}
        )
)
@Getter
public class HotelRoomDetailsEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bookable_unit_id",
            nullable = false,
            unique = true
    )
    private BookableUnitEntity bookableUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private PropertyEntity property;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_category", nullable = false)
    private RoomCategory roomCategory;
}

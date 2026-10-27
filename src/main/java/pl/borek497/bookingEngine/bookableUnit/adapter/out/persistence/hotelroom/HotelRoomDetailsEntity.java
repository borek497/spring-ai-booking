package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.hotelroom;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence.BookableUnitEntity;
import pl.borek497.bookingEngine.common.adapter.out.BaseEntity;
import pl.borek497.bookingEngine.property.adapter.out.persistence.PropertyEntity;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "hotel_room_details",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_room_details_property_hotel_room_number",
                columnNames = {"property_id", "hotel_room_number"}
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

    @Column(name = "hotel_room_number", nullable = false)
    private String hotelRoomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "hotel_room_category", nullable = false)
    private HotelRoomCategory hotelRoomCategory;
}

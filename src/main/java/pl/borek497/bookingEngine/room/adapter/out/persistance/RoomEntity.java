package pl.borek497.bookingEngine.room.adapter.out.persistance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.jpa.BaseEntity;
import pl.borek497.bookingEngine.property.adapter.out.persistence.PropertyEntity;
import pl.borek497.bookingEngine.room.domain.RoomStatus;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "room")
public class RoomEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private PropertyEntity property;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private int capacity;

    @Column(name = "is_private_kitchen", nullable = false)
    private boolean privateKitchen;

    @Column(name = "is_private_bathroom", nullable = false)
    private boolean privateBathroom;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_status", nullable = false)
    private RoomStatus roomStatus;

    @Column(name = "price_per_night", nullable = false)
    private BigDecimal pricePerNight;
}

package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.jpa.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cottage_details")
@Getter
public class CottageDetailsEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bookable_unit_id",
            nullable = false,
            unique = true
    )
    private BookableUnitEntity bookableUnit;

    @Column(nullable = false)
    private String name;

    @Column(name = "additional_data", nullable = false)
    private String additionalData;

    @Column(name = "room_count", nullable = false)
    private int roomCount;

    @Column(nullable = false)
    private int capacity;

    @Column(name = "private_bathroom", nullable = false)
    private boolean privateBathroom;

    @Column(name = "private_kitchen", nullable = false)
    private boolean privateKitchen;
}
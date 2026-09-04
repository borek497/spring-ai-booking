package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance.BookableUnitEntity;
import pl.borek497.bookingEngine.jpa.BaseEntity;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apartment_details")
@Getter
public class ApartmentDetailsEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bookable_unit_id",
            nullable = false,
            unique = true
    )
    private BookableUnitEntity bookableUnit;

    @Column(nullable = false)
    private String name;

    @Column(name = "total_capacity", nullable = false)
    private int totalCapacity;

    @OneToMany(
            mappedBy = "apartmentDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ApartmentRoomDetailsEntity> rooms;

    @Column(name = "private_bathroom", nullable = false)
    private boolean privateBathroom;

    @Column(name = "private_kitchen", nullable = false)
    private boolean privateKitchen;
}
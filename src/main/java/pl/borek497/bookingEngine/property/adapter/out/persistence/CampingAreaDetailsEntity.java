package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance.BookableUnitEntity;
import pl.borek497.bookingEngine.jpa.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "camping_area_details")
@Getter
public class CampingAreaDetailsEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bookable_unit_id",
            nullable = false,
            unique = true
    )
    private BookableUnitEntity bookableUnit;

    @Column(nullable = false)
    private int capacity;
}
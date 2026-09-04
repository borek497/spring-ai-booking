package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.jpa.BaseEntity;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnitType;
import pl.borek497.bookingEngine.property.adapter.out.persistence.PropertyEntity;
import pl.borek497.bookingEngine.property.domain.model.Status;

import java.math.BigDecimal;

@Entity
@Table(name = "bookable_unit")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookableUnitEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private PropertyEntity property;

    @Enumerated(EnumType.STRING)
    @Column(name = "bookable_unit_type", nullable = false)
    private BookableUnitType bookableUnitType;

    @Column(name = "max_guests", nullable = false)
    private int maxGuests;

    @Column(
            name = "base_price_per_night",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal basePricePerNight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}

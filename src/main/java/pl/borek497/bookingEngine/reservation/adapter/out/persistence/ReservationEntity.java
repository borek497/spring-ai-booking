package pl.borek497.bookingEngine.reservation.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.bookableUnit.adapter.out.persistance.BookableUnitEntity;
import pl.borek497.bookingEngine.jpa.BaseEntity;
import pl.borek497.bookingEngine.reservation.domain.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "reservations")
public class ReservationEntity extends BaseEntity {

    @Column(name = "bookable_unit_id", nullable = false)
    private Long bookableUnitId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    @Column(
            name = "total_price",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal totalPrice;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "guests_number")
    private int guestsNumber;
}

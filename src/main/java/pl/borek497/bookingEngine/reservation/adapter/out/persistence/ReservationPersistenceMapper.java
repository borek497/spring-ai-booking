package pl.borek497.bookingEngine.reservation.adapter.out.persistence;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

@Component
public class ReservationPersistenceMapper {

    public ReservationEntity toEntity(Reservation reservation) {
        return new ReservationEntity(
                reservation.getBookableUnitId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getReservationStatus(),
                reservation.getTotalPrice(),
                reservation.getUserId(),
                reservation.getGuestsNumber()
        );
    }

    public Reservation toDomain(ReservationEntity entity) {
        return new Reservation(
                entity.getId(),
                entity.getBookableUnitId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getReservationStatus(),
                entity.getTotalPrice(),
                entity.getUserId(),
                entity.getGuestsNumber()
        );
    }
}

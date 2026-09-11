package pl.borek497.bookingEngine.reservation.adapter.out.persistence;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.reservation.application.command.CreateReservationCommand;
import pl.borek497.bookingEngine.reservation.application.port.out.ReservationRepositoryPort;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

@Repository
@AllArgsConstructor
class ReservationAdapter implements ReservationRepositoryPort {

    private final ReservationJpaRepository reservationJpaRepository;
    private final ReservationPersistenceMapper mapper;

    @Override
    public Reservation save(Reservation reservation) {
        ReservationEntity reservationEntity = mapper.toEntity(reservation);
        ReservationEntity savedEntity = reservationJpaRepository.save(reservationEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public boolean existsOverlappingReservation(CreateReservationCommand command) {
        return reservationJpaRepository
                .findAll()
                .stream()
                .anyMatch(reservation ->
                        reservation.getBookableUnitId().equals(command.getBookableUnitId())
                                && reservation.getStartDate().isBefore(command.getEndDate())
                                && reservation.getEndDate().isAfter(command.getStartDate())
                );
    }
}

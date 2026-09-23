package pl.borek497.bookingEngine.reservation.adapter.out.persistence;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.reservation.application.port.out.ReservationRepositoryPort;
import pl.borek497.bookingEngine.reservation.domain.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public boolean existsOverlappingReservation(Long bookableUnitId,
                                                LocalDate startDate,
                                                LocalDate endDate) {
        return reservationJpaRepository
                .findAll()
                .stream()
                .anyMatch(reservation ->
                        reservation.getBookableUnitId().equals(bookableUnitId)
                                && reservation.getStartDate().isBefore(endDate)
                                && reservation.getEndDate().isAfter(startDate)
                );
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationJpaRepository
                .findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Reservation> findByCustomerId(Long customerId) {
        return reservationJpaRepository
                .findAllByCustomerId(customerId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}

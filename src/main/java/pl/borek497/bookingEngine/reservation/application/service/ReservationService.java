package pl.borek497.bookingEngine.reservation.application.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.borek497.bookingEngine.bookableUnit.application.port.out.BookableUnitRepositoryPort;
import pl.borek497.bookingEngine.bookableUnit.domain.BookableUnit;
import pl.borek497.bookingEngine.customer.application.port.out.CustomerRepositoryPort;
import pl.borek497.bookingEngine.customer.domain.Customer;
import pl.borek497.bookingEngine.exceptions.EntityNotFoundException;
import pl.borek497.bookingEngine.property.domain.model.Status;
import pl.borek497.bookingEngine.reservation.application.ReservationDetails;
import pl.borek497.bookingEngine.reservation.application.command.CreateReservationCommand;
import pl.borek497.bookingEngine.reservation.application.port.in.ReservationUseCase;
import pl.borek497.bookingEngine.reservation.application.port.out.ReservationRepositoryPort;
import pl.borek497.bookingEngine.reservation.domain.Reservation;
import pl.borek497.bookingEngine.reservation.domain.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
@Validated
class ReservationService implements ReservationUseCase {

    private final ReservationRepositoryPort reservationRepositoryPort;
    private final BookableUnitRepositoryPort bookableUnitRepository;
    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    @Transactional
    public Reservation createReservation(CreateReservationCommand command) {
        validateDates(command);
        validateCustomer(command.getCustomerId());

        BookableUnit bookableUnit = getBookableUnitByIdForUpdate(command.getBookableUnitId());
        validateGuests(command, bookableUnit);
        validateBookableUnitStatus(bookableUnit);
        validateAvailability(command);
        BigDecimal totalPrice = calculateTotalPrice(command, bookableUnit);

        Reservation reservation = new Reservation(
                null,
                bookableUnit.getId(),
                command.getStartDate(),
                command.getEndDate(),
                ReservationStatus.NEW,
                totalPrice,
                command.getCustomerId(),
                command.getNumberOfGuests()
        );

        return reservationRepositoryPort.save(reservation);
    }

    @Override
    public ReservationDetails getDetailsById(Long reservationId) {
        Reservation reservation = reservationRepositoryPort
                .findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException(Reservation.class, reservationId));

        Long customerId = reservation.getCustomerId();
        Customer customer = customerRepositoryPort
                .findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException(Customer.class, customerId));

        return new ReservationDetails(reservation, customer);
    }

    @Override
    public List<Reservation> getByCustomerId(Long customerId) {
        return reservationRepositoryPort.findByCustomerId(customerId);
    }

    private void validateCustomer(Long customerId) {
        if (customerId == null || customerId <= 0) {
            throw new IllegalArgumentException("CustomerId must be positive");
        }

        customerRepositoryPort
                .findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException(Customer.class, customerId));
    }

    private void validateDates(CreateReservationCommand command) {
        if (command.getStartDate() == null || command.getEndDate() == null) {
            throw new IllegalArgumentException("Start date and end date are required");
        }

        if (!command.getEndDate().isAfter(command.getStartDate())) {
            throw new IllegalArgumentException("End date must be after start date");
        }

        if (command.getStartDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Start date cannot be in the past");
        }
    }

    private void validateAvailability(CreateReservationCommand command) {
        if (reservationRepositoryPort.existsOverlappingReservation(command.getBookableUnitId(), command.getStartDate(), command.getEndDate())) {
            throw new IllegalStateException(
                    "Bookable unit is not available for selected dates"
            );
        }
    }

    private void validateBookableUnitStatus(BookableUnit bookableUnit) {
        if (bookableUnit.getStatus() != Status.ACTIVE) {
            throw new IllegalStateException("Bookable unit is not active");
        }
    }

    private BookableUnit getBookableUnitByIdForUpdate(Long bookableUnitId) {
        if (bookableUnitId == null || bookableUnitId <= 0) {
            throw new IllegalArgumentException("Bookable unit ID must be positive");
        }

        return bookableUnitRepository
                .findByIdForUpdate(bookableUnitId)
                .orElseThrow(() -> new EntityNotFoundException(BookableUnit.class, bookableUnitId));
    }

    private BigDecimal calculateTotalPrice(CreateReservationCommand command, BookableUnit bookableUnit) {
        return BigDecimal.valueOf(countNights(command)).multiply(bookableUnit.getBasePricePerNight());
    }

    private long countNights(CreateReservationCommand command) {
        return ChronoUnit.DAYS.between(command.getStartDate(), command.getEndDate());
    }

    private void validateGuests(CreateReservationCommand command, BookableUnit bookableUnit) {
        if (command.getNumberOfGuests() > bookableUnit.getMaxGuests()) {
            throw new IllegalArgumentException("Too many guests for selected entity");
        }

        if (command.getNumberOfGuests() <=0) {
            throw new IllegalArgumentException("Number of guests must be positive");
        }
    }
}

package pl.borek497.bookingEngine.reservation.application.command;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CreateReservationCommand {

    @NotNull
    @Positive
    private Long bookableUnitId;

    @NotNull
    @FutureOrPresent
    private LocalDate startDate;

    @NotNull
    @FutureOrPresent
    private LocalDate endDate;

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    @Positive
    private int numberOfGuests;
}

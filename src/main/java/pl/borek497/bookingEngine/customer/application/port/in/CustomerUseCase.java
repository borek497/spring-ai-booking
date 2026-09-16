package pl.borek497.bookingEngine.customer.application.port.in;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import pl.borek497.bookingEngine.customer.application.command.CreateCustomerCommand;
import pl.borek497.bookingEngine.customer.application.command.UpdateCustomerCommand;
import pl.borek497.bookingEngine.customer.domain.Customer;

public interface CustomerUseCase {

    Customer create(@NotNull @Valid CreateCustomerCommand command);
    Customer getById(@NotNull @Positive Long id);
    Customer update(@NotNull @Positive Long id, @NotNull @Valid UpdateCustomerCommand command);
}

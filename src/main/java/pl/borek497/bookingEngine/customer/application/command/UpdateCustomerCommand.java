package pl.borek497.bookingEngine.customer.application.command;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class UpdateCustomerCommand {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Email
    private String email;
}

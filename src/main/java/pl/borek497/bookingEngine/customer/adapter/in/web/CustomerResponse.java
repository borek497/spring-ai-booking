package pl.borek497.bookingEngine.customer.adapter.in.web;

import pl.borek497.bookingEngine.customer.domain.Customer;
import pl.borek497.bookingEngine.customer.domain.CustomerStatus;

public record CustomerResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        CustomerStatus status
) {

    public static CustomerResponse fromModel(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getStatus()
        );
    }
}

package pl.borek497.bookingEngine.customer.domain;

import lombok.Getter;

@Getter
public class Customer {
    private final Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private CustomerStatus status;

    public Customer(
            Long id,
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            CustomerStatus status
    ) {
        this.id = id;
        this.firstName = validateRequiredText(firstName, "First name");
        this.lastName = validateRequiredText(lastName, "Last name");
        this.email = validateRequiredText(email, "Email");
        this.phoneNumber = validateRequiredText(phoneNumber, "Phone number");
        this.status = validateStatus(status);
    }

    public static Customer create(
            String firstName,
            String lastName,
            String email,
            String phoneNumber
    ) {
        return new Customer(
                null,
                firstName,
                lastName,
                email,
                phoneNumber,
                CustomerStatus.ACTIVE
        );
    }

    public void changeName(String firstName, String lastName) {
        String validatedFirstName = validateRequiredText(firstName, "First name");
        String validatedLastName = validateRequiredText(lastName, "Last name");

        this.firstName = validatedFirstName;
        this.lastName = validatedLastName;
    }

    public void changeEmail(String email) {
        this.email = validateRequiredText(email, "Email");
    }

    public void changePhoneNumber(String phoneNumber) {
        this.phoneNumber = validateRequiredText(phoneNumber, "Phone number");
    }

    public void block() {
        this.status = CustomerStatus.BLOCKED;
    }

    public void activate() {
        this.status = CustomerStatus.ACTIVE;
    }

    private static String validateRequiredText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " is required");
        }
        return value.strip();
    }

    private static CustomerStatus validateStatus(CustomerStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Customer status is required");
        }
        return status;
    }
}

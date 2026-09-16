package pl.borek497.bookingEngine.customer.domain.exceptions;

public class CustomerEmailAlreadyExistsException extends RuntimeException {

    public CustomerEmailAlreadyExistsException() {
        super("Customer with this email already exists");
    }
}

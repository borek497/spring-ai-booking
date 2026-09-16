package pl.borek497.bookingEngine.customer.application.port.out;

import pl.borek497.bookingEngine.customer.domain.Customer;

import java.util.Optional;

public interface CustomerRepositoryPort {

    Customer save(Customer command);
    Optional<Customer> findById(Long id);
    boolean existsByEmail(String email);
    Customer update(Customer customer);
    boolean existsByEmailAndIdNot(String email, Long customerId);
}

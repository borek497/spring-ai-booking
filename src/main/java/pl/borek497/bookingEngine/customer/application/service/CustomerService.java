package pl.borek497.bookingEngine.customer.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.borek497.bookingEngine.customer.application.command.CreateCustomerCommand;
import pl.borek497.bookingEngine.customer.application.command.UpdateCustomerCommand;
import pl.borek497.bookingEngine.customer.application.port.in.CustomerUseCase;
import pl.borek497.bookingEngine.customer.application.port.out.CustomerRepositoryPort;
import pl.borek497.bookingEngine.customer.domain.Customer;
import pl.borek497.bookingEngine.customer.domain.exceptions.CustomerEmailAlreadyExistsException;
import pl.borek497.bookingEngine.common.application.exceptions.EntityNotFoundException;

@Service
@Validated
@RequiredArgsConstructor
class CustomerService implements CustomerUseCase {

    private final CustomerRepositoryPort repositoryPort;

    @Override
    public Customer create(CreateCustomerCommand command) {
        Customer customer = Customer.create(
                command.getFirstName(),
                command.getLastName(),
                command.getEmail(),
                command.getPhoneNumber()

        );

        if (repositoryPort.existsByEmail(customer.getEmail())) {
            throw new CustomerEmailAlreadyExistsException();
        }
        return repositoryPort.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        validateCustomerId(id);
        return repositoryPort
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Customer.class, id));
    }

    @Override
    @Transactional
    public Customer update(Long id, UpdateCustomerCommand command) {
        if (command.getFirstName() == null
                && command.getLastName() == null
                && command.getEmail() == null
                && command.getPhoneNumber() == null) {
            throw new IllegalArgumentException("At least one field must be provided");
        }

        Customer customer = getById(id);

        if (command.getEmail() != null
                && repositoryPort.existsByEmailAndIdNot(command.getEmail(), id)) {
            throw new CustomerEmailAlreadyExistsException();
        }

        if (command.getFirstName() != null || command.getLastName() != null) {
            customer.changeName(
                    command.getFirstName() != null ? command.getFirstName() : customer.getFirstName(),
                    command.getLastName() != null ? command.getLastName() : customer.getLastName()
            );
        }

        if (command.getEmail() != null) {
            customer.changeEmail(command.getEmail());
        }

        if (command.getPhoneNumber() != null) {
            customer.changePhoneNumber(command.getPhoneNumber());
        }

        return repositoryPort.update(customer);
    }

    private void validateCustomerId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive");
        }
    }
}

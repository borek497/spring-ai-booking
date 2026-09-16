package pl.borek497.bookingEngine.customer.adapter.out.persistance;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import pl.borek497.bookingEngine.customer.application.port.out.CustomerRepositoryPort;
import pl.borek497.bookingEngine.customer.domain.Customer;
import pl.borek497.bookingEngine.customer.domain.exceptions.CustomerEmailAlreadyExistsException;
import pl.borek497.bookingEngine.exceptions.EntityNotFoundException;

import java.util.Optional;

@Repository
@AllArgsConstructor
class CustomerRepositoryAdapter implements CustomerRepositoryPort {

    private final CustomerJpaRepository jpaRepository;
    private final CustomerPersistenceMapper mapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = mapper.toEntity(customer);
        CustomerEntity saved = jpaRepository.save(customerEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository
                .findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public Customer update(Customer customer) {
        CustomerEntity customerEntity = jpaRepository.findById(customer.getId()).orElseThrow(() -> new EntityNotFoundException(Customer.class, customer.getId()));
        customerEntity.updateContactDetails(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );

        try {
            CustomerEntity saved = jpaRepository.saveAndFlush(customerEntity);
            return mapper.toDomain(saved);
        } catch (DataIntegrityViolationException exception) {
            throw new CustomerEmailAlreadyExistsException();
        }
    }

    @Override
    public boolean existsByEmailAndIdNot(String email, Long customerId) {
        return jpaRepository.existsByEmailAndIdNot(email, customerId);
    }
}

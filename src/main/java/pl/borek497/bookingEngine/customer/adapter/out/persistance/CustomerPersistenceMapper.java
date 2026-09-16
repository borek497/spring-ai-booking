package pl.borek497.bookingEngine.customer.adapter.out.persistance;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.customer.domain.Customer;

@Component
public class CustomerPersistenceMapper {

    public CustomerEntity toEntity(Customer customer) {
        return new CustomerEntity(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getStatus()
        );
    }

    public Customer toDomain(CustomerEntity entity) {
        return new Customer(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getStatus()
        );
    }
}

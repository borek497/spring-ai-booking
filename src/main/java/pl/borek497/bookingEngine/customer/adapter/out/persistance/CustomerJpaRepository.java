package pl.borek497.bookingEngine.customer.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long customerId);
}

package pl.borek497.bookingEngine.customer.adapter.in.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.borek497.bookingEngine.customer.application.command.CreateCustomerCommand;
import pl.borek497.bookingEngine.customer.application.command.UpdateCustomerCommand;
import pl.borek497.bookingEngine.customer.application.port.in.CustomerUseCase;
import pl.borek497.bookingEngine.customer.domain.Customer;

import java.net.URI;

import static pl.borek497.bookingEngine.common.adapter.in.web.ResourceUriFactory.forCreatedResource;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
class CustomerController {

    private final CustomerUseCase customerUseCase;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CreateCustomerCommand command) {
        Customer customer = customerUseCase.create(command);
        URI uri = forCreatedResource(customer.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable Long id) {
        return CustomerResponse.fromModel(customerUseCase.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id, @Valid @RequestBody UpdateCustomerCommand command) {
        Customer customer = customerUseCase.update(id, command);
        return ResponseEntity.ok(CustomerResponse.fromModel(customer));
    }
}

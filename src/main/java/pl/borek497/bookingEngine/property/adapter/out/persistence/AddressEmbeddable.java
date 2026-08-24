package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddressEmbeddable {

    @Column(name = "zip_code", nullable = false) private String zipCode;
    @Column(name = "city", nullable = false) private String city;
    @Column(name = "street", nullable = false) private String street;
    @Column(name = "house_number", nullable = false) private String houseNumber;
    @Column(name = "flat_number") private String flatNumber;
}

package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.borek497.bookingEngine.jpa.BaseEntity;
import pl.borek497.bookingEngine.property.domain.model.PropertyStatus;
import pl.borek497.bookingEngine.property.domain.model.PropertyType;
import pl.borek497.bookingEngine.property.domain.model.Province;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "property")
@Getter
public class PropertyEntity extends BaseEntity {

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type")
    private PropertyType propertyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_status")
    private PropertyStatus propertyStatus;

    @Convert(converter = ProvinceConverter.class)
    @Column(name = "province_id", nullable = false)
    private Province province;

    @Embedded
    private AddressEmbeddable address;
}

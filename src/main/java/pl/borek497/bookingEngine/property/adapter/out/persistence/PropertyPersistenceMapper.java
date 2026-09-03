package pl.borek497.bookingEngine.property.adapter.out.persistence;

import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.property.domain.model.Address;
import pl.borek497.bookingEngine.property.domain.model.Property;

@Component
public class PropertyPersistenceMapper {

    public PropertyEntity toEntity(Property property) {
        return new PropertyEntity(
                //property.getId(), - tutaj musiałbym to dodać, ale nie mam konstruktora
                property.getName(),
                property.getDescription(),
                property.getPropertyType(),
                property.getStatus(),
                property.getProvince(),
                toAddressEmbeddable(property.getAddress())
        );
    }

    public Property toDomain(PropertyEntity entity) {
        return new Property(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPropertyType(),
                entity.getStatus(),
                entity.getProvince(),
                toAddressDomain(entity.getAddress())
        );
    }

    private Address toAddressDomain(AddressEmbeddable embeddable) {
        return new Address(
                embeddable.getZipCode(),
                embeddable.getCity(),
                embeddable.getStreet(),
                embeddable.getHouseNumber(),
                embeddable.getFlatNumber()
        );
    }

    private AddressEmbeddable toAddressEmbeddable(Address address) {
        return new AddressEmbeddable(
                address.getZipCode(),
                address.getCity(),
                address.getStreet(),
                address.getHouseNumber(),
                address.getFlatNumber()
        );
    }
}

package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import pl.borek497.bookingEngine.property.domain.model.Province;

@Converter
public class ProvinceConverter implements AttributeConverter<Province, Long> {

    @Override
    public Long convertToDatabaseColumn(Province province) {
        return province == null ? null : province.getId();
    }

    @Override
    public Province convertToEntityAttribute(Long id) {
        return id == null ? null : Province.fromId(id);
    }
}

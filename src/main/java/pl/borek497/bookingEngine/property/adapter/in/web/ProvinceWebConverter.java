package pl.borek497.bookingEngine.property.adapter.in.web;

import org.jspecify.annotations.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.property.domain.model.Province;

@Component
public class ProvinceWebConverter implements Converter<String, Province> {

    @Override
    public Province convert(@NonNull String source) {
        return Province.fromName(source);
    }
}

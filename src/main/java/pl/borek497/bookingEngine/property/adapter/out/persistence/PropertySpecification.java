package pl.borek497.bookingEngine.property.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pl.borek497.bookingEngine.property.application.PropertySearchCriteria;
import pl.borek497.bookingEngine.property.domain.model.Status;
import pl.borek497.bookingEngine.property.domain.model.PropertyType;
import pl.borek497.bookingEngine.property.domain.model.Province;

import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertySpecification {

    public static Specification<PropertyEntity> from(PropertySearchCriteria criteria) {
        Specification<PropertyEntity> specification = Specification.unrestricted();

        if (criteria.province() != null) {
            specification = specification.and(hasProvince(criteria.province()));
        }

        if (criteria.city() != null) {
            specification = specification.and(hasCity(criteria.city().toLowerCase()));
        }

        if (criteria.status() != null) {
            specification = specification.and(hasStatus(criteria.status()));
        }

        if (criteria.propertyType() != null) {
            specification = specification.and(hasType(criteria.propertyType()));
        }

        return specification;
    }

    private static Specification<PropertyEntity> hasProvince(Province province) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("province"), province));
    }

    private static Specification<PropertyEntity> hasCity(String city) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("address").get("city")),
                        city.trim().toLowerCase(Locale.ROOT)));
    }

    private static Specification<PropertyEntity> hasStatus(Status status) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("propertyStatus"), status));
    }

    private static Specification<PropertyEntity> hasType(PropertyType propertyType) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("propertyType"), propertyType));
    }
}

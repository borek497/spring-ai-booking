package pl.borek497.bookingEngine.property.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.borek497.bookingEngine.property.domain.model.Province;

import java.util.List;

public interface PropertyJpaRepository extends
        JpaRepository<PropertyEntity, Long>,
        JpaSpecificationExecutor<PropertyEntity> {

    List<PropertyEntity> findByProvince(Province province);

}

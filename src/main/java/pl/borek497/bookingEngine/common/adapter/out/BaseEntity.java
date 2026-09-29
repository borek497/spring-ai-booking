package pl.borek497.bookingEngine.common.adapter.out;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private long version;
}

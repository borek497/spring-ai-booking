package pl.borek497.bookingEngine.bookableUnit.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import pl.borek497.bookingEngine.common.adapter.out.BaseEntity;

@Entity
@Table(name = "apartment_room_details")
@Getter
public class ApartmentRoomDetailsEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_details_id", nullable = false)
    private ApartmentDetailsEntity apartmentDetails;

    @Column(nullable = false)
    private int capacity;
}
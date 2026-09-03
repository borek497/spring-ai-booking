package pl.borek497.bookingEngine.property.adapter.out.persistence;

import jakarta.persistence.*;
import pl.borek497.bookingEngine.jpa.BaseEntity;

@Entity
@Table(name = "apartment_room_details")
public class ApartmentRoomDetailsEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_details_id", nullable = false)
    private ApartmentDetailsEntity apartmentDetails;

    @Column(nullable = false)
    private int capacity;
}
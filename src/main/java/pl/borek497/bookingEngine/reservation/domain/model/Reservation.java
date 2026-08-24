//package pl.borek497.bookingEngine.reservation.domain.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import lombok.NoArgsConstructor;
//import pl.borek497.bookingEngine.jpa.BaseEntity;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Entity
//@NoArgsConstructor
//@Table(name = "reservation")
//public class Reservation extends BaseEntity {
//
//    private Long propertyId;
//    private Long guestId;
//    private LocalDate startDate;
//    private LocalDate endDate;
//    private ReservationStatus status;
//    private BigDecimal totalPrice;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//
//    public Reservation(Long propertyId,
//                       Long guestId,
//                       LocalDate startDate,
//                       LocalDate endDate,
//                       ReservationStatus status,
//                       BigDecimal totalPrice,
//                       LocalDateTime createdAt,
//                       LocalDateTime updatedAt) {
//        this.propertyId = propertyId;
//        this.guestId = guestId;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.status = status;
//        this.totalPrice = totalPrice;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }
//}

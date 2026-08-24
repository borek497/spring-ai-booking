package pl.borek497.bookingEngine.room.adapter.in.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.borek497.bookingEngine.room.application.port.in.RoomUseCase;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
class RoomController {

    private final RoomUseCase roomUseCase;

    @GetMapping("/properties/{propertyId}/rooms/available")
    public List<RoomResponse> getAvailableRooms(@PathVariable Long propertyId) {
        return roomUseCase
                .findAvailableByPropertyId(propertyId)
                .stream()
                .map(RoomResponse::from)
                .toList();
    }

    @GetMapping
    public List<RoomResponse> getByCity(@RequestParam String city) {
        return roomUseCase
                .findByCity(city)
                .stream()
                .map(RoomResponse::from)
                .toList();
    }
}

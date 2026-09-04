package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.BookableUnitUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.SearchRoomsUseCase;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

import java.util.List;

import static pl.borek497.bookingEngine.bookableUnit.adapter.in.web.BookableUnitResponse.from;

@RestController
@RequestMapping("/bookable-units")
@RequiredArgsConstructor
class BookableUnitController {

    private final BookableUnitUseCase bookableUnitUseCase;
    private final SearchRoomsUseCase searchRoomsUseCase;

    @GetMapping
    public List<BookableUnitResponse> getByPropertyId(@RequestParam Long propertyId) {
        return bookableUnitUseCase
                .getByPropertyId(propertyId)
                .stream()
                .map(BookableUnitResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public BookableUnitResponse getById(@PathVariable Long id) {
        return from(bookableUnitUseCase.getById(id));
    }

    @GetMapping("/rooms")
    public List<RoomResponse> getRoomsByPropertyIdAndRoomCategory(
            @RequestParam Long propertyId,
            @RequestParam RoomCategory roomCategory) {
        return searchRoomsUseCase
                .findRoomsByPropertyIdAndRoomCategory(propertyId, roomCategory)
                .stream()
                .map(RoomResponse::from)
                .toList();
    }
}

package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSearchCriteria;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.BookableUnitUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.SearchRoomsUseCase;
import pl.borek497.bookingEngine.property.domain.RoomCategory;

import java.util.List;

import static pl.borek497.bookingEngine.bookableUnit.adapter.in.web.BookableUnitSummaryResponse.fromModel;

@RestController
@RequestMapping("/bookable-units")
@RequiredArgsConstructor
class BookableUnitController {

    private final BookableUnitUseCase bookableUnitUseCase;
    private final SearchRoomsUseCase searchRoomsUseCase;

    @GetMapping
    public List<BookableUnitSummaryResponse> getByPropertyId(@RequestParam Long propertyId) {
        return bookableUnitUseCase
                .getByPropertyId(propertyId)
                .stream()
                .map(BookableUnitSummaryResponse::fromModel)
                .toList();
    }

    @GetMapping("/{id}")
    public BookableUnitSummaryResponse getById(@PathVariable Long id) {
        return fromModel(bookableUnitUseCase.getByBookableUnitId(id));
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

    @GetMapping("/available")
    public List<BookableUnitSummaryResponse> getAvailableUnits(@Valid @ModelAttribute BookableUnitSearchCriteria criteria) {
        return bookableUnitUseCase
                .search(criteria)
                .stream()
                .map(BookableUnitSummaryResponse::fromModel)
                .toList();
    }

    @GetMapping("/{id}/details")
    public BookableUnitDetailsResponse getDetailsById(@PathVariable Long id) {
        return BookableUnitDetailsResponse.fromModel(bookableUnitUseCase.getDetailsById(id));
    }
}

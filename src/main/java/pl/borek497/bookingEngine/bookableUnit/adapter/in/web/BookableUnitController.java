package pl.borek497.bookingEngine.bookableUnit.adapter.in.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.borek497.bookingEngine.bookableUnit.application.BookableUnitSearchCriteria;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.BookableUnitUseCase;
import pl.borek497.bookingEngine.bookableUnit.application.port.in.SearchHotelRoomUseCase;
import pl.borek497.bookingEngine.bookableUnit.domain.HotelRoomCategory;

import java.util.List;

import static pl.borek497.bookingEngine.bookableUnit.adapter.in.web.BookableUnitResponse.fromModel;

@RestController
@RequestMapping("/bookable-units")
@RequiredArgsConstructor
class BookableUnitController {

    private final BookableUnitUseCase bookableUnitUseCase;
    private final SearchHotelRoomUseCase searchHotelRoomUseCase;

    @GetMapping
    public List<BookableUnitResponse> getByPropertyId(@RequestParam Long propertyId) {
        return bookableUnitUseCase
                .getByPropertyId(propertyId)
                .stream()
                .map(BookableUnitResponse::fromModel)
                .toList();
    }

    //ENDPOINT nie jest potrzebny bo niżej mamy /details który posiada bardziej kompletne dane jednostki rezerwowalnej
    @GetMapping("/{id}")
    public BookableUnitResponse getById(@PathVariable Long id) {
        return fromModel(bookableUnitUseCase.getByBookableUnitId(id));
    }

    //Wyszukiwarka pokoi hotelowych
    @GetMapping("/hotel-rooms")
    public List<HotelRoomResponse> getHotelRoomsByPropertyIdAndHotelRoomCategory(
            @RequestParam Long propertyId,
            @RequestParam HotelRoomCategory hotelRoomCategory) {
        return searchHotelRoomUseCase
                .findRoomsByPropertyIdAndRoomCategory(propertyId, hotelRoomCategory)
                .stream()
                .map(HotelRoomResponse::from)
                .toList();
    }

    @GetMapping("/available")
    public List<BookableUnitResponse> getAvailableUnits(@Valid @ModelAttribute BookableUnitSearchCriteria criteria) {
        return bookableUnitUseCase
                .search(criteria)
                .stream()
                .map(BookableUnitResponse::fromModel)
                .toList();
    }

    /**
    Pobranie szczegółów jednostki rezerwacyjnej
     */
    @GetMapping("/{id}/details")
    public BookableUnitDetailsResponse getDetailsById(@PathVariable Long id) {
        return BookableUnitDetailsResponse.fromModel(bookableUnitUseCase.getDetailsById(id));
    }
}

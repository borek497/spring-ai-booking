package pl.borek497.bookingEngine.property.adapter.in.web;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.borek497.bookingEngine.property.application.PropertySearchCriteria;
import pl.borek497.bookingEngine.property.application.port.in.PropertyUseCase;

import java.util.List;

@RestController
@RequestMapping("/properties")
@AllArgsConstructor
class PropertyController {

    private final PropertyUseCase propertyUseCase;

//    @GetMapping
//    public List<PropertyResponse> getProperties(@RequestParam(required = false) String province) {
//        List<Property> properties = province == null
//                ? propertyUseCase.findAll()
//                : propertyUseCase.findByProvince(province);
//
//        return properties
//                .stream()
//                .map(PropertyResponse::from)
//                .toList();
//    }

    @GetMapping
    public List<PropertyResponse> getProperties(@ModelAttribute PropertySearchCriteria criteria) {
        return propertyUseCase
                .search(criteria)
                .stream()
                .map(PropertyResponse::from)
                .toList();

    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyResponse> getById(@PathVariable Long id) {
        return propertyUseCase
                .findById(id)
                .map(PropertyResponse::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

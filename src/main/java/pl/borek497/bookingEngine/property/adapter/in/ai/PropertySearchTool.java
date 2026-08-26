package pl.borek497.bookingEngine.property.adapter.in.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import pl.borek497.bookingEngine.property.adapter.in.web.PropertyResponse;
import pl.borek497.bookingEngine.property.application.PropertySearchCriteria;
import pl.borek497.bookingEngine.property.application.port.in.PropertyUseCase;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PropertySearchTool {

    private final PropertyUseCase propertyUseCase;

    @Tool(
            description = """
                Search for properties using criteria provided by the user.
                Use this tool when the user wants to find a hotel,
                apartment, house or other property.
                """,
            returnDirect = true
    )
    public List<PropertyResponse> searchProperties(PropertySearchCriteria criteria) {
        return propertyUseCase
                .search(criteria)
                .stream()
                .map(PropertyResponse::from)
                .toList();
    }
//
//    @Tool(
//            description = "Search for hotels in a given city. Use this tool when user wants to find a hotel.",
//            returnDirect = true
//    )
//    public List<Property> search(
//            @ToolParam(description = "City where the hotel should be located")
//            String city) {
//
//        return propertyUseCase.findByCity(city);
//    }
}

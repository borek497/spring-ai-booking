package pl.borek497.bookingEngine.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> type, Long id) {
        super("%s with id %s not found".formatted(
                        type.getSimpleName(),
                        id
                )
        );
    }
}

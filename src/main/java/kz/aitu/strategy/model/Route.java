package kz.aitu.strategy.model;

/**
 * Immutable record representing the calculated route between two points.
 * Encapsulates the transport mode, route metrics (distance, duration), and instructions.
 */
public record Route(
    String travelMode,
    String origin,
    String destination,
    double distanceKm,
    int durationMinutes,
    String instructions
) {
    @Override
    public String toString() {
        return String.format(
            "[%s Route] %s -> %s | Distance: %.1f km | Duration: %d min | Route: %s",
            travelMode, origin, destination, distanceKm, durationMinutes, instructions
        );
    }
}

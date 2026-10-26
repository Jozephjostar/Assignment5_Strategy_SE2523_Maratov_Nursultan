package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

/**
 * Concrete strategy encapsulating bicycle route planning.
 * Prioritizes dedicated bicycle paths, secondary residential streets, and flat elevation profiles.
 */
public class CycleStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String origin, String destination) {
        // Concrete bicycle routing algorithm:
        // Prefers designated bike lanes along EXPO boulevard and avoids heavy traffic
        double distanceKm = 10.5;
        int durationMinutes = 35;
        String instructions = "Follow EXPO bike lane network -> continue along Saraishyk St cycle path";

        return new Route("Bicycle", origin, destination, distanceKm, durationMinutes, instructions);
    }
}

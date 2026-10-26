package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

/**
 * Concrete strategy encapsulating road and highway routing for motor vehicles.
 * Prioritizes high-speed thoroughfares, bypasses pedestrian areas, and accounts for traffic.
 */
public class CarStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String origin, String destination) {
        // Concrete car routing algorithm:
        // Follows major avenues/highways (e.g., Mangilik El Ave, Kabanbay Batyr Ave)
        double distanceKm = 14.8;
        int durationMinutes = 20;
        String instructions = "Follow Mangilik El Ave -> take Kabanbay Batyr overpass (Fastest route, avoids traffic jams)";

        return new Route("Car", origin, destination, distanceKm, durationMinutes, instructions);
    }
}

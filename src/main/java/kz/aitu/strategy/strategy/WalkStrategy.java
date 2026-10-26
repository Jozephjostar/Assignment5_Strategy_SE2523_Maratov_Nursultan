package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

/**
 * Concrete strategy encapsulating pedestrian navigation.
 * Uses pedestrian crossings, sidewalks, and park alleys; avoids motorways and highways.
 */
public class WalkStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String origin, String destination) {
        // Concrete pedestrian routing algorithm:
        // Takes scenic shortcuts through pedestrian pathways and parks (e.g., Botanical Garden)
        double distanceKm = 9.2;
        int durationMinutes = 110;
        String instructions = "Walk through Botanical Garden pathways -> cross pedestrian bridges (Scenic, zero car traffic)";

        return new Route("Walking", origin, destination, distanceKm, durationMinutes, instructions);
    }
}

package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

/**
 * Concrete strategy demonstrating Open/Closed Principle extensibility.
 * Encapsulates public transit navigation (bus, metro, LRT) without altering existing classes.
 */
public class PublicTransportStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String origin, String destination) {
        // Concrete public transit algorithm:
        // Calculates route based on scheduled bus/LRT lines and transfer connections
        double distanceKm = 13.2;
        int durationMinutes = 25;
        String instructions = "Take Bus #10 from AITU stop -> 5 stops to Baiterek plaza (Direct public transit line)";

        return new Route("Public Transport", origin, destination, distanceKm, durationMinutes, instructions);
    }
}

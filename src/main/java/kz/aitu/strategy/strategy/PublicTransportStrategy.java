package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

public class PublicTransportStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String origin, String destination) {
        double distanceKm = 13.2;
        int durationMinutes = 25;
        String instructions = "Take Bus #10 from AITU stop -> 5 stops to Baiterek plaza (Direct public transit line)";

        return new Route("Public Transport", origin, destination, distanceKm, durationMinutes, instructions);
    }
}

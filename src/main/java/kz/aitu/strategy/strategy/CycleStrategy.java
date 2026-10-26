package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

public class CycleStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String origin, String destination) {
        double distanceKm = 10.5;
        int durationMinutes = 35;
        String instructions = "Follow EXPO bike lane network -> continue along Saraishyk St cycle path";

        return new Route("Bicycle", origin, destination, distanceKm, durationMinutes, instructions);
    }
}

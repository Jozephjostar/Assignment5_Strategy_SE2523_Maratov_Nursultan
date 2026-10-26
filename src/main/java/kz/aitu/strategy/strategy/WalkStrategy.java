package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

public class WalkStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String origin, String destination) {
        double distanceKm = 9.2;
        int durationMinutes = 110;
        String instructions = "Walk through Botanical Garden pathways -> cross pedestrian bridges (Scenic, zero car traffic)";

        return new Route("Walking", origin, destination, distanceKm, durationMinutes, instructions);
    }
}

package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

public class CarStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String origin, String destination) {
        double distanceKm = 14.8;
        int durationMinutes = 20;
        String instructions = "Follow Mangilik El Ave -> take Kabanbay Batyr overpass (Fastest route, avoids traffic jams)";

        return new Route("Car", origin, destination, distanceKm, durationMinutes, instructions);
    }
}

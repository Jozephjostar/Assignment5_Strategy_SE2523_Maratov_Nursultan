package kz.aitu.strategy.context;

import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.strategy.RouteStrategy;

public class Navigator {

    private RouteStrategy strategy;

    public Navigator() {
    }

    public Navigator(RouteStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(RouteStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null.");
        }
        this.strategy = strategy;
    }

    public RouteStrategy getStrategy() {
        return strategy;
    }

    public Route planRoute(String origin, String destination) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is not set. Please set a RouteStrategy before planning.");
        }
        if (origin == null || origin.isBlank() || destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Origin and destination must not be null or empty.");
        }

        return strategy.buildRoute(origin, destination);
    }
}

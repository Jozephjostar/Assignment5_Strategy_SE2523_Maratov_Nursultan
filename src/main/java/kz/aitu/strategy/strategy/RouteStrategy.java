package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

public interface RouteStrategy {
    Route buildRoute(String origin, String destination);
}

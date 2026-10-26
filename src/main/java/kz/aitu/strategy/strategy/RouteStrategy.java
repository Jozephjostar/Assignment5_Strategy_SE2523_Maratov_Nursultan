package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;

/**
 * Strategy interface defining the execution method common to all route planning algorithms.
 */
public interface RouteStrategy {

    /**
     * Calculates a route between two geographic points using a specific transport algorithm.
     *
     * @param origin Starting point of the journey
     * @param destination Target destination
     * @return Computed Route instance containing route details
     */
    Route buildRoute(String origin, String destination);
}

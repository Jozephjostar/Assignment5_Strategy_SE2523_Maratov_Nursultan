package kz.aitu.strategy.context;

import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.strategy.RouteStrategy;

/**
 * Context class that maintains a reference to a RouteStrategy instance
 * and delegates route building to whichever strategy is currently configured.
 * 
 * Supports dynamic runtime strategy switching via {@link #setStrategy(RouteStrategy)}.
 */
public class Navigator {

    private RouteStrategy strategy;

    /**
     * Default constructor for Navigator.
     */
    public Navigator() {
    }

    /**
     * Parameterized constructor to initialize the Navigator with a strategy.
     *
     * @param strategy The initial route planning strategy
     */
    public Navigator(RouteStrategy strategy) {
        setStrategy(strategy);
    }

    /**
     * Sets or switches the current route planning strategy at runtime.
     *
     * @param strategy The new strategy implementation
     */
    public void setStrategy(RouteStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null.");
        }
        this.strategy = strategy;
    }

    /**
     * Returns the currently configured strategy.
     *
     * @return current RouteStrategy
     */
    public RouteStrategy getStrategy() {
        return strategy;
    }

    /**
     * Executes route planning by delegating directly to the active strategy.
     * Notice: There are NO conditionals (if/switch) determining algorithm behavior.
     *
     * @param origin Starting point
     * @param destination Destination point
     * @return Calculated Route object
     */
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

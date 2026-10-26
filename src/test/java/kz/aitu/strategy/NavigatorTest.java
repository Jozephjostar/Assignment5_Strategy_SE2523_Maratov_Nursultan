package kz.aitu.strategy;

import kz.aitu.strategy.context.Navigator;
import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.strategy.CarStrategy;
import kz.aitu.strategy.strategy.CycleStrategy;
import kz.aitu.strategy.strategy.PublicTransportStrategy;
import kz.aitu.strategy.strategy.WalkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Navigator and Strategy Pattern Unit Tests")
class NavigatorTest {

    private final String origin = "Astana IT University";
    private final String destination = "Baiterek Monument";

    @Test
    @DisplayName("Should correctly plan route using initial CarStrategy")
    void shouldPlanRouteUsingCarStrategy() {
        Navigator navigator = new Navigator(new CarStrategy());
        Route route = navigator.planRoute(origin, destination);

        assertNotNull(route);
        assertEquals("Car", route.travelMode());
        assertEquals(origin, route.origin());
        assertEquals(destination, route.destination());
        assertEquals(14.8, route.distanceKm());
        assertEquals(20, route.durationMinutes());
    }

    @Test
    @DisplayName("Should dynamically switch to WalkStrategy at runtime")
    void shouldSwitchToWalkStrategyAtRuntime() {
        Navigator navigator = new Navigator(new CarStrategy());

        // Dynamic switch at runtime
        navigator.setStrategy(new WalkStrategy());
        Route route = navigator.planRoute(origin, destination);

        assertNotNull(route);
        assertEquals("Walking", route.travelMode());
        assertEquals(9.2, route.distanceKm());
        assertEquals(110, route.durationMinutes());
    }

    @Test
    @DisplayName("Should dynamically switch to CycleStrategy at runtime")
    void shouldSwitchToCycleStrategyAtRuntime() {
        Navigator navigator = new Navigator(new WalkStrategy());

        // Dynamic switch at runtime
        navigator.setStrategy(new CycleStrategy());
        Route route = navigator.planRoute(origin, destination);

        assertNotNull(route);
        assertEquals("Bicycle", route.travelMode());
        assertEquals(10.5, route.distanceKm());
        assertEquals(35, route.durationMinutes());
    }

    @Test
    @DisplayName("Should seamlessly support newly added PublicTransportStrategy without modifying Navigator")
    void shouldSupportNewPublicTransportStrategy() {
        Navigator navigator = new Navigator(new CycleStrategy());

        // Demonstrating Open/Closed Principle
        navigator.setStrategy(new PublicTransportStrategy());
        Route route = navigator.planRoute(origin, destination);

        assertNotNull(route);
        assertEquals("Public Transport", route.travelMode());
        assertEquals(13.2, route.distanceKm());
        assertEquals(25, route.durationMinutes());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when strategy passed to setStrategy is null")
    void shouldThrowWhenStrategyIsNull() {
        Navigator navigator = new Navigator();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> navigator.setStrategy(null));
        assertEquals("Strategy cannot be null.", ex.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalStateException when planRoute called without setting strategy")
    void shouldThrowWhenPlanningWithoutStrategy() {
        Navigator navigator = new Navigator();
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> navigator.planRoute(origin, destination));
        assertTrue(ex.getMessage().contains("Strategy is not set"));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when origin or destination is blank")
    void shouldThrowWhenEndpointsAreBlank() {
        Navigator navigator = new Navigator(new CarStrategy());
        assertThrows(IllegalArgumentException.class, () -> navigator.planRoute("", destination));
        assertThrows(IllegalArgumentException.class, () -> navigator.planRoute(origin, "   "));
        assertThrows(IllegalArgumentException.class, () -> navigator.planRoute(null, destination));
    }
}

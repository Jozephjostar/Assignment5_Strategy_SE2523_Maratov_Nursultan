package kz.aitu.strategy;

import kz.aitu.strategy.context.Navigator;
import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.strategy.CarStrategy;
import kz.aitu.strategy.strategy.CycleStrategy;
import kz.aitu.strategy.strategy.PublicTransportStrategy;
import kz.aitu.strategy.strategy.WalkStrategy;

/**
 * Client entry point for Assignment #5 - Strategy Pattern.
 * 
 * Demonstrates:
 * 1. Configuring Context (Navigator) with interchangeable strategies.
 * 2. Dynamic runtime strategy switching without modifying Navigator.
 * 3. Elimination of conditional (if/switch) branching in the Context.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  Assignment #5: Strategy Behavioral Design Pattern (Route Planning)");
        System.out.println("  Course: ShP-2216 Software Design Patterns | Astana IT University");
        System.out.println("================================================================================\n");

        final String origin = "Astana IT University (EXPO C1)";
        final String destination = "Baiterek Monument";

        System.out.println("Trip: [" + origin + "]  --->  [" + destination + "]\n");

        // 1. Client instantiates Navigator context with initial CarStrategy
        System.out.println(">>> 1. Initial Strategy: Driving by Car");
        Navigator navigator = new Navigator(new CarStrategy());
        Route carRoute = navigator.planRoute(origin, destination);
        System.out.println("    " + carRoute);
        System.out.println();

        // 2. Client dynamically switches strategy at runtime to WalkStrategy
        System.out.println(">>> 2. Runtime Switch: Switching to Pedestrian Walking");
        navigator.setStrategy(new WalkStrategy());
        Route walkRoute = navigator.planRoute(origin, destination);
        System.out.println("    " + walkRoute);
        System.out.println();

        // 3. Client dynamically switches strategy at runtime to CycleStrategy
        System.out.println(">>> 3. Runtime Switch: Switching to Bicycle");
        navigator.setStrategy(new CycleStrategy());
        Route cycleRoute = navigator.planRoute(origin, destination);
        System.out.println("    " + cycleRoute);
        System.out.println();

        // 4. Client dynamically switches to PublicTransportStrategy (OCP demonstration)
        System.out.println(">>> 4. Runtime Switch: Newly Added Strategy (Public Transit / Bus)");
        navigator.setStrategy(new PublicTransportStrategy());
        Route transitRoute = navigator.planRoute(origin, destination);
        System.out.println("    " + transitRoute);
        System.out.println();

        System.out.println("================================================================================");
        System.out.println("  Execution completed successfully with zero conditional branching in Context!");
        System.out.println("================================================================================");
    }
}

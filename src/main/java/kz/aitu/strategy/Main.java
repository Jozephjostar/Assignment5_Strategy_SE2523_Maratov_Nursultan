package kz.aitu.strategy;

import kz.aitu.strategy.context.Navigator;
import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.strategy.CarStrategy;
import kz.aitu.strategy.strategy.CycleStrategy;
import kz.aitu.strategy.strategy.PublicTransportStrategy;
import kz.aitu.strategy.strategy.WalkStrategy;

public class Main {

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  Assignment #5: Strategy Behavioral Design Pattern (Route Planning)");
        System.out.println("  Course: ShP-2216 Software Design Patterns | Astana IT University");
        System.out.println("================================================================================\n");

        final String origin = "Astana IT University (EXPO C1)";
        final String destination = "Baiterek Monument";

        System.out.println("Trip: [" + origin + "]  --->  [" + destination + "]\n");

        System.out.println(">>> 1. Initial Strategy: Driving by Car");
        Navigator navigator = new Navigator(new CarStrategy());
        Route carRoute = navigator.planRoute(origin, destination);
        System.out.println("    " + carRoute);
        System.out.println();

        System.out.println(">>> 2. Runtime Switch: Switching to Pedestrian Walking");
        navigator.setStrategy(new WalkStrategy());
        Route walkRoute = navigator.planRoute(origin, destination);
        System.out.println("    " + walkRoute);
        System.out.println();

        System.out.println(">>> 3. Runtime Switch: Switching to Bicycle");
        navigator.setStrategy(new CycleStrategy());
        Route cycleRoute = navigator.planRoute(origin, destination);
        System.out.println("    " + cycleRoute);
        System.out.println();

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

# Assignment #5: Strategy Design Pattern (Route Planning)

**Course:** ShP-2216 – Software Design Patterns  
**Program:** Software Engineering (OP 6B06102), 2nd Year, 4th Trimester  
**Institution:** Astana IT University  
**Student:** Nursultan Maratov (SE-2523)  
**Language:** Java 17 (IntelliJ IDEA Recommended)

---

## 📌 Project Overview

This project implements the **Strategy behavioral design pattern** in Java for a **Navigation / Route Planning system** (Option A).

The system allows dynamic calculation of travel routes between locations (e.g., from *Astana IT University* to *Baiterek Monument*) using interchangeable travel algorithms (**Car**, **Walk**, **Cycle**, and **Public Transport**). The algorithms can be swapped dynamically at runtime without modifying the context (`Navigator`) and without any conditional (`if/else` or `switch`) branching statements.

---

## 🏗 Project Structure

```text
Assignment5_SE2523_Maratov_Nursultan/
├── pom.xml                                    # Maven configuration (Java 17, JUnit 5)
├── README.md                                  # Setup and usage guide
├── REPORT.md                                  # Moodle submission report
└── src/
    ├── main/
    │   └── java/
    │       └── kz/aitu/strategy/
    │           ├── Main.java                  # Client application demonstration
    │           ├── context/
    │           │   └── Navigator.java         # Context class delegating to Strategy
    │           ├── model/
    │           │   └── Route.java             # Immutable Java 17 record for route data
    │           └── strategy/
    │               ├── RouteStrategy.java     # Strategy interface
    │               ├── CarStrategy.java       # Concrete strategy: Motor vehicle route
    │               ├── WalkStrategy.java      # Concrete strategy: Pedestrian route
    │               ├── CycleStrategy.java     # Concrete strategy: Bicycle route
    │               └── PublicTransportStrategy.java # Extensible strategy: Bus/transit
    └── test/
        └── java/
            └── kz/aitu/strategy/
                └── NavigatorTest.java         # Comprehensive JUnit 5 unit tests
```

---

## 🚀 How to Open and Run in IntelliJ IDEA

1. **Open in IntelliJ IDEA:**
   - Launch IntelliJ IDEA.
   - Click **File** -> **Open...**
   - Select the project folder: `Assignment5_SE2523_Maratov_Nursultan`.
   - IntelliJ IDEA will automatically recognize Maven and import all dependencies.
2. **Run Application:**
   - Navigate to `src/main/java/kz/aitu/strategy/Main.java`.
   - Click the green **Run** ▶ button next to `public static void main(String[] args)`.
3. **Run Tests:**
   - Navigate to `src/test/java/kz/aitu/strategy/NavigatorTest.java`.
   - Right-click and choose **Run 'NavigatorTest'**.

---

## 💻 How to Build and Run from Terminal

- **Compile and run tests:**
  ```bash
  mvn test
  ```
- **Execute application:**
  ```bash
  mvn exec:java
  ```
- **Or compile and run manually using JDK 17+:**
  ```bash
  javac -d out $(find src/main/java -name "*.java")
  java -cp out kz.aitu.strategy.Main
  ```

---

## ➕ How to Add a New Strategy (Open/Closed Principle)

To introduce a new travel mode (e.g., `ScooterStrategy` or `DroneStrategy`):

1. **Implement `RouteStrategy`:**
   ```java
   package kz.aitu.strategy.strategy;

   import kz.aitu.strategy.model.Route;

   public class ScooterStrategy implements RouteStrategy {
       @Override
       public Route buildRoute(String origin, String destination) {
           double distanceKm = 11.0;
           int durationMinutes = 28;
           String details = "Via bike lanes and wide pedestrian sidewalks; max 25 km/h.";
           return new Route("Scooter", origin, destination, distanceKm, durationMinutes, details);
       }
   }
   ```
2. **Use it in Client:**
   ```java
   navigator.setStrategy(new ScooterStrategy());
   Route scooterRoute = navigator.planRoute("AITU", "Mega Silk Way");
   System.out.println(scooterRoute);
   ```

> **Notice:** The `Navigator` context and all existing strategy classes remain completely untouched.

---

## 🧪 Unit Tests Summary

All 7 test cases verify:
- Initial strategy routing (Car).
- Dynamic runtime switching to Walking and Cycling.
- Dynamic switching to newly added Public Transport strategy.
- Null defense: proper `IllegalArgumentException` and `IllegalStateException` throwing.

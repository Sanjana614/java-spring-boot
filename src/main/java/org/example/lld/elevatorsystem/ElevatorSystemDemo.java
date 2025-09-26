package org.example.lld.elevatorsystem;

import org.example.lld.elevatorsystem.enums.Direction;

public class ElevatorSystemDemo {
    public static void main(String[] args) throws InterruptedException {
        int numElevator = 2;
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance(numElevator);

        elevatorSystem.start();
        System.out.println("\n================= Elevator system started. ConsoleDisplay is observing =================\n");

        // 1. External Request: User at floor 5 wants to go UP.
        System.out.println("[SIMULATION] Step 1 -> External request at floor 5 (UP)");
        elevatorSystem.requestElevator(5, Direction.UP);
        Thread.sleep(100); // Wait for the elevator to start moving

        // 2. Internal Request: Assume E1 took the previous request.
        System.out.println("[SIMULATION] Step 2 -> Internal request: Elevator-1, user selects floor 10");
        elevatorSystem.selectFloor(1, 10);
        Thread.sleep(200);

        // 3. External Request: User at floor 3 wants to go DOWN.
        System.out.println("[SIMULATION] Step 3 -> External request at floor 3 (DOWN)");
        elevatorSystem.requestElevator(3, Direction.DOWN);
        Thread.sleep(300);

        // 4. Internal Request: User in E2 presses 1.
        System.out.println("[SIMULATION] Step 4 -> Internal request: Elevator-2, user selects floor 1");
        elevatorSystem.selectFloor(2, 1);

        // Let the simulation run for a while to observe the display updates
        System.out.println("\n[SIMULATION] Letting system run for 1 second...\n");
        Thread.sleep(1000);

        // Shutdown the system
        System.out.println("[SIMULATION] Shutting down the system...");
        elevatorSystem.shutdown();

        System.out.println("\n================= SIMULATION END =================\n");
    }
}

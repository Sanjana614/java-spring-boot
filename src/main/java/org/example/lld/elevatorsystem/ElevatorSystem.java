package org.example.lld.elevatorsystem;

import org.example.lld.elevatorsystem.enums.Direction;
import org.example.lld.elevatorsystem.enums.Source;
import org.example.lld.elevatorsystem.model.Elevator;
import org.example.lld.elevatorsystem.model.Request;
import org.example.lld.elevatorsystem.observer.Display;
import org.example.lld.elevatorsystem.strategy.ElevatorSelectionStrategy;
import org.example.lld.elevatorsystem.strategy.NearestElevatorSelectionStrategy;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorSystem {
    private static volatile ElevatorSystem instance;
    private final Map<Integer, Elevator> elevatorMap = new HashMap<>();
    private ElevatorSelectionStrategy elevatorSelectionStrategy;
    private final ExecutorService executorService;

    public ElevatorSystem(int num) {
        this.elevatorSelectionStrategy = new NearestElevatorSelectionStrategy();
        this.executorService = Executors.newFixedThreadPool(num);
        Display display = new Display();

        for (int i = 1; i <= num; i++) {
            Elevator elevator = new Elevator(i, display);
            this.elevatorMap.put(i, elevator);
            System.out.printf("[SYSTEM] Created Elevator-%d%n", i);
        }
    }

    public static ElevatorSystem getInstance(int num) {
        if (Objects.isNull(instance)) {
            synchronized (ElevatorSystem.class) {
                if (Objects.isNull(instance)) {
                    instance = new ElevatorSystem(num);
                    System.out.printf("[SYSTEM] ElevatorSystem initialized with %d elevators%n", num);
                }
            }
        }
        return instance;
    }

    public void start() {
        System.out.println("[SYSTEM] Starting all elevators...");
        elevatorMap.values().forEach(executorService::submit);
    }

    public void requestElevator(int floor, Direction direction) {
        System.out.printf("[REQUEST] External request received -> floor=%d, direction=%s%n", floor, direction);

        Request request = new Request(floor, direction, Source.EXTERNAL);
        Elevator elevator = elevatorSelectionStrategy
                .selectElevator(new ArrayList<>(elevatorMap.values()), request);

        System.out.printf("[SYSTEM] Assigned External request (floor=%d, dir=%s) to Elevator-%d%n",
                floor, direction, elevator.getId());

        elevator.addRequest(request);
    }

    public void selectFloor(int elevatorId, int floor) {
        Elevator elevator = elevatorMap.get(elevatorId);
        Direction direction = floor > elevator.getCurrentFloor() ? Direction.UP : Direction.DOWN;

        System.out.printf("[REQUEST] Internal request received -> Elevator-%d, targetFloor=%d, computedDirection=%s%n",
                elevatorId, floor, direction);

        Request request = new Request(floor, direction, Source.INTERNAL);
        elevator.addRequest(request);
    }

    public void shutdown() {
        System.out.println("[SYSTEM] Shutting down all elevators...");
        for (Elevator elevator : elevatorMap.values()) {
            System.out.printf("[SYSTEM] Stopping Elevator-%d%n", elevator.getId());
            elevator.stop();
        }
        executorService.shutdown();
        System.out.println("[SYSTEM] Elevator system shut down complete.");
    }
}

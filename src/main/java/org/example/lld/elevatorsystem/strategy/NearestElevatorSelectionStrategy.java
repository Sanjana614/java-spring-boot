package org.example.lld.elevatorsystem.strategy;

import org.example.lld.elevatorsystem.enums.Direction;
import org.example.lld.elevatorsystem.model.Elevator;
import org.example.lld.elevatorsystem.model.Request;

import java.util.List;

public class NearestElevatorSelectionStrategy implements ElevatorSelectionStrategy {
    private final static int oppositeDirectionCost = 5;

    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request) {
        System.out.println("[SELECTION] Starting elevator selection for request: " + request);

        Elevator nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance;
            Direction elevatorDirection = elevator.getCurrentState().getDirection();
            Direction requestedDirection = request.getDirection();

            if (Direction.IDLE.equals(elevatorDirection) || requestedDirection.equals(elevatorDirection)) {
                distance = Math.abs(request.getTargetFloor() - elevator.getCurrentFloor());
                System.out.println("[SELECTION] Elevator-" + elevator.getId() +
                        " is moving in same direction or idle. Distance=" + distance +
                        " (currentFloor=" + elevator.getCurrentFloor() + ")");
            } else {
                distance = oppositeDirectionCost + Math.abs(request.getTargetFloor() - elevator.getCurrentFloor());
                System.out.println("[SELECTION] Elevator-" + elevator.getId() +
                        " is moving opposite direction. Penalized Distance=" + distance +
                        " (currentFloor=" + elevator.getCurrentFloor() + ")");
            }

            if (distance < minDistance) {
                nearestElevator = elevator;
                minDistance = distance;
                System.out.println("[SELECTION] Elevator-" + elevator.getId() + " is current best candidate with distance " + distance);
            }
        }

        System.out.println("[SELECTION] Final selected elevator: Elevator-" + nearestElevator.getId() + " for request " + request);
        return nearestElevator;
    }

}

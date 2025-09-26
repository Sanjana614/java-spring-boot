package org.example.lld.elevatorsystem.state;

import org.example.lld.elevatorsystem.enums.Direction;
import org.example.lld.elevatorsystem.enums.Source;
import org.example.lld.elevatorsystem.model.Elevator;
import org.example.lld.elevatorsystem.model.Request;
import org.springframework.util.CollectionUtils;

public class MovingDownState implements ElevatorState {

    @Override
    public void move(Elevator elevator) {
        if (CollectionUtils.isEmpty(elevator.getDownRequests())) {
            System.out.println("[STATE] Elevator-" + elevator.getId() + " has no more DOWN requests. Switching to IDLE.");
            elevator.setCurrentState(new IdleState());
            return;
        }

        int nextDestinationFloor = elevator.getDownRequests().first();
        int currentFloor = elevator.getCurrentFloor() - 1;
        elevator.setCurrentFloor(currentFloor);

        System.out.println("[MOVE] Elevator-" + elevator.getId() + " moving DOWN. Current floor: "
                + currentFloor + " | Next target: " + nextDestinationFloor);

        if (nextDestinationFloor == currentFloor) {
            Integer floor = elevator.getDownRequests().pollFirst();
            System.out.println("[ARRIVAL] Elevator-" + elevator.getId() + " reached target floor: " + floor);
            // (optional) Door open/close logic could go here
        }

        if (CollectionUtils.isEmpty(elevator.getDownRequests())) {
            System.out.println("[STATE] Elevator-" + elevator.getId() + " completed all DOWN requests. Switching to IDLE.");
            elevator.setCurrentState(new IdleState());
        }
    }

    @Override
    public void addRequest(Elevator elevator, Request request) {
        System.out.println("[REQUEST] Elevator-" + elevator.getId() + " received request while moving DOWN: " + request);

        if (Source.INTERNAL.equals(request.getSource())) {
            if (elevator.getCurrentFloor() < request.getTargetFloor()) {
                System.out.println("[REQUEST] Internal UP request added to UP queue: floor=" + request.getTargetFloor());
                elevator.addUpRequest(request.getTargetFloor());
            } else if (elevator.getCurrentFloor() > request.getTargetFloor()) {
                System.out.println("[REQUEST] Internal DOWN request added to DOWN queue: floor=" + request.getTargetFloor());
                elevator.addDownRequest(request.getTargetFloor());
            }
            return;
        }

        if (Direction.DOWN.equals(request.getDirection()) && elevator.getCurrentFloor() > request.getTargetFloor()) {
            System.out.println("[REQUEST] External DOWN request added to DOWN queue: floor=" + request.getTargetFloor());
            elevator.addDownRequest(request.getTargetFloor());
        } else if (Direction.UP.equals(request.getDirection())) {
            System.out.println("[REQUEST] External UP request added to UP queue: floor=" + request.getTargetFloor());
            elevator.addUpRequest(request.getTargetFloor());
        }
    }

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }
}

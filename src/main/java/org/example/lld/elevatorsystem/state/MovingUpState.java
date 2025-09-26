package org.example.lld.elevatorsystem.state;

import org.example.lld.elevatorsystem.enums.Direction;
import org.example.lld.elevatorsystem.enums.Source;
import org.example.lld.elevatorsystem.model.Elevator;
import org.example.lld.elevatorsystem.model.Request;
import org.springframework.util.CollectionUtils;

public class MovingUpState implements ElevatorState {

    @Override
    public void move(Elevator elevator) {
        if (CollectionUtils.isEmpty(elevator.getUpRequests())) {
            System.out.println("[STATE] Elevator-" + elevator.getId() + " has no more UP requests. Switching to IDLE.");
            elevator.setCurrentState(new IdleState());
            return;
        }

        int nextRequestedFloor = elevator.getUpRequests().first();
        int currentFloor = elevator.getCurrentFloor() + 1;
        elevator.setCurrentFloor(currentFloor);

        System.out.println("[MOVE] Elevator-" + elevator.getId() + " moving UP. Current floor: " + currentFloor + " | Next target: " + nextRequestedFloor);

        if (currentFloor == nextRequestedFloor) {
            Integer floor = elevator.getUpRequests().pollFirst();
            System.out.println("[ARRIVAL] Elevator-" + elevator.getId() + " reached target floor: " + floor);

            // You might later hook in door open/close logic here
        }

        if (CollectionUtils.isEmpty(elevator.getUpRequests())) {
            System.out.println("[STATE] Elevator-" + elevator.getId() + " completed all UP requests. Switching to IDLE.");
            elevator.setCurrentState(new IdleState());
        }
    }

    @Override
    public void addRequest(Elevator elevator, Request request) {
        System.out.println("[REQUEST] Elevator-" + elevator.getId() + " received request while moving UP: " + request);

        if (Source.INTERNAL.equals(request.getSource())) {
            if (elevator.getCurrentFloor() < request.getTargetFloor()) {
                System.out.println("[REQUEST] Internal UP request added to queue: floor=" + request.getTargetFloor());
                elevator.addUpRequest(request.getTargetFloor());
            } else if (elevator.getCurrentFloor() > request.getTargetFloor()) {
                System.out.println("[REQUEST] Internal DOWN request deferred to DOWN queue: floor=" + request.getTargetFloor());
                elevator.addDownRequest(request.getTargetFloor());
            }
            return;
        }

        if (Direction.UP.equals(request.getDirection()) && elevator.getCurrentFloor() < request.getTargetFloor()) {
            System.out.println("[REQUEST] External UP request added to UP queue: floor=" + request.getTargetFloor());
            elevator.addUpRequest(request.getTargetFloor());
        } else if (Direction.DOWN.equals(request.getDirection())) {
            System.out.println("[REQUEST] External DOWN request added to DOWN queue: floor=" + request.getTargetFloor());
            elevator.addDownRequest(request.getTargetFloor());
        }
    }

    @Override
    public Direction getDirection() {
        return Direction.UP;
    }
}

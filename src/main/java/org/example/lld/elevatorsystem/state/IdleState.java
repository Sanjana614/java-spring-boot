package org.example.lld.elevatorsystem.state;

import org.example.lld.elevatorsystem.enums.Direction;
import org.example.lld.elevatorsystem.model.Elevator;
import org.example.lld.elevatorsystem.model.Request;
import org.springframework.util.CollectionUtils;

import java.util.Set;

public class IdleState implements ElevatorState {

    @Override
    public void move(Elevator elevator) {
        Set<Integer> upRequests = elevator.getUpRequests();
        Set<Integer> downRequests = elevator.getDownRequests();

        if (!CollectionUtils.isEmpty(upRequests)) {
            System.out.println("Elevator " + elevator.getId() + " transitioning from IDLE to MOVING UP");
            elevator.setCurrentState(new MovingUpState());
        } else if (!CollectionUtils.isEmpty(downRequests)) {
            System.out.println("Elevator " + elevator.getId() + " transitioning from IDLE to MOVING DOWN");
            elevator.setCurrentState(new MovingDownState());
        } else {
            System.out.println("Elevator " + elevator.getId() + " remains IDLE at floor " + elevator.getCurrentFloor());
        }
    }

    @Override
    public void addRequest(Elevator elevator, Request request) {
        System.out.println("Elevator " + elevator.getId() + " (IDLE) received request: " + request);

        if (elevator.getCurrentFloor() < request.getTargetFloor()) {
            System.out.println("Adding UP request for floor " + request.getTargetFloor());
            elevator.addUpRequest(request.getTargetFloor());
        } else if (elevator.getCurrentFloor() > request.getTargetFloor()) {
            System.out.println("Adding DOWN request for floor " + request.getTargetFloor());
            elevator.addDownRequest(request.getTargetFloor());
        } else {
            System.out.println("Elevator " + elevator.getId() + " is already at requested floor " + request.getTargetFloor());
        }
    }

    @Override
    public Direction getDirection() {
        return Direction.IDLE;
    }
}

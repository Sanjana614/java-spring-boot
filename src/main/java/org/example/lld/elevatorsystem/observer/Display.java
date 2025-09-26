package org.example.lld.elevatorsystem.observer;

import org.example.lld.elevatorsystem.model.Elevator;

public class Display implements ElevatorObserver {

    @Override
    public void update(Elevator elevator) {
        System.out.println("[DISPLAY] Elevator " + elevator.getId() +
                " | Current Floor: " + elevator.getCurrentFloor() +
                " | Direction: " + elevator.getCurrentState().getDirection());
    }
}

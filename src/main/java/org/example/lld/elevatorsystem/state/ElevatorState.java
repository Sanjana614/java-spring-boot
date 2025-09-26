package org.example.lld.elevatorsystem.state;

import org.example.lld.elevatorsystem.enums.Direction;
import org.example.lld.elevatorsystem.model.Elevator;
import org.example.lld.elevatorsystem.model.Request;

public interface ElevatorState {
    void move(Elevator elevator);

    void addRequest(Elevator elevator, Request request);

    Direction getDirection();
}

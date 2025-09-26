package org.example.lld.elevatorsystem.observer;

import org.example.lld.elevatorsystem.model.Elevator;

public interface ElevatorObserver {
    void update(Elevator elevator);
}

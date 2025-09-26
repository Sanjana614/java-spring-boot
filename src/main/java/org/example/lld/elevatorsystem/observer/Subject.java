package org.example.lld.elevatorsystem.observer;

public interface Subject {
    void addObserver(ElevatorObserver elevatorObserver);
    void removeObserver(ElevatorObserver elevatorObserver);
    void notifyAllObserver();
}

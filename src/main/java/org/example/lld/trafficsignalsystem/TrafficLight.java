package org.example.lld.trafficsignalsystem;

public class TrafficLight {
    private SignalState signalState;
    private final Direction direction;

    public TrafficLight(Direction direction) {
        this.direction = direction;
        this.signalState = new RedState();
    }
}

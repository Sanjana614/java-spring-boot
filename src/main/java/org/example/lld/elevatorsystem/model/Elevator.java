package org.example.lld.elevatorsystem.model;

import org.example.lld.elevatorsystem.observer.ElevatorObserver;
import org.example.lld.elevatorsystem.observer.Subject;
import org.example.lld.elevatorsystem.state.ElevatorState;
import org.example.lld.elevatorsystem.state.IdleState;

import java.util.*;

public class Elevator implements Subject, Runnable {
    private final int id;
    private ElevatorState currentState;
    private Integer currentFloor;
    private final List<ElevatorObserver> observers = new ArrayList<>();
    private final TreeSet<Integer> upRequests = new TreeSet<>();
    private final TreeSet<Integer> downRequests = new TreeSet<>((a, b) -> b - a);
    private boolean active;

    public Elevator(int id, ElevatorObserver observer) {
        this.id = id;
        this.currentState = new IdleState();
        this.currentFloor = 1;
        this.active = true;
        this.addObserver(observer);
        System.out.println("Elevator " + id + " initialized at floor " + currentFloor + " in IDLE state");
    }

    public int getId() {
        return this.id;
    }

    public synchronized void addUpRequest(Integer floor) {
        System.out.println("Elevator " + id + " received UP request for floor " + floor);
        this.upRequests.add(floor);
    }

    public synchronized void addDownRequest(Integer floor) {
        System.out.println("Elevator " + id + " received DOWN request for floor " + floor);
        this.downRequests.add(floor);
    }

    public void addRequest(Request request) {
        System.out.println("Elevator " + id + " delegating request " + request + " to current state " + currentState.getClass().getSimpleName());
        this.currentState.addRequest(this, request);
    }

    public TreeSet<Integer> getUpRequests() {
        return this.upRequests;
    }

    public TreeSet<Integer> getDownRequests() {
        return this.downRequests;
    }

    public ElevatorState getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(ElevatorState currentState) {
        System.out.println("Elevator " + id + " changing state from "
                + this.currentState.getClass().getSimpleName() + " to "
                + currentState.getClass().getSimpleName());
        notifyAllObserver();
        this.currentState = currentState;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        System.out.println("Elevator " + id + " set active=" + active);
        this.active = active;
    }

    public Integer getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        System.out.println("Elevator " + id + " moving to floor " + currentFloor);
        this.currentFloor = currentFloor;
    }

    @Override
    public void addObserver(ElevatorObserver elevatorObserver) {
        this.observers.add(elevatorObserver);
    }

    @Override
    public void removeObserver(ElevatorObserver elevatorObserver) {
        this.observers.remove(elevatorObserver);
    }

    @Override
    public void notifyAllObserver() {
        this.observers.forEach(observer -> observer.update(this));
    }

    public void move() {
        this.currentState.move(this);
    }

    public void stop() {
        System.out.println("Elevator " + id + " stopping...");
        this.active = false;
    }

    @Override
    public void run() {
        while (active) {
            try {
                move();
                Thread.sleep(100);
            } catch (Exception exception) {
                System.err.println("Elevator " + id + " encountered error: " + exception.getMessage());
                Thread.currentThread().interrupt();
                this.active = false;
            }
        }
        System.out.println("Elevator " + id + " has stopped running.");
    }
}

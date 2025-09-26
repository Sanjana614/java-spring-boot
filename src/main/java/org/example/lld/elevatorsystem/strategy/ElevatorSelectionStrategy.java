package org.example.lld.elevatorsystem.strategy;

import org.example.lld.elevatorsystem.ElevatorSystem;
import org.example.lld.elevatorsystem.model.Elevator;
import org.example.lld.elevatorsystem.model.Request;

import java.util.List;

public interface ElevatorSelectionStrategy {

    Elevator selectElevator(List<Elevator> elevators, Request request);
}

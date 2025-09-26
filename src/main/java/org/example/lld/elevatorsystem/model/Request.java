package org.example.lld.elevatorsystem.model;

import org.example.lld.elevatorsystem.enums.Direction;
import org.example.lld.elevatorsystem.enums.Source;

public class Request {
    private final int targetFloor;
    private final Direction direction;
    private final Source source;

    public Request(int targetFloor, Direction direction, Source source) {
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.source = source;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public Source getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Request{" +
                "targetFloor=" + targetFloor +
                ", direction=" + direction +
                ", source=" + source +
                '}';
    }
}

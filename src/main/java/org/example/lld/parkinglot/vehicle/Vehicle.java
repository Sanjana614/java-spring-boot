package org.example.lld.parkinglot.vehicle;

public abstract class Vehicle {
    private final String id;
    private final VehicleType vehicleType;

    public Vehicle(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

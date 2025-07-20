package org.example.lld.parkinglot;

import org.example.lld.parkinglot.vehicle.Vehicle;
import org.example.lld.parkinglot.vehicle.VehicleType;

import java.util.Objects;

public class Spot {
    private final String id;
    private final VehicleType vehicleType;
    private Vehicle vehicle;

    public Spot(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return Objects.isNull(vehicle);
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void releaseVehicle() {
        this.vehicle = null;
    }

    public String getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id='" + id + '\'' +
                ", vehicleType=" + vehicleType +
                ", available=" + Objects.isNull(vehicle) +
                '}';
    }
}

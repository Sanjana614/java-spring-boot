package org.example.lld.parkinglot;

import org.example.lld.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ParkingLot {
    private final String id;
    private final String name;
    private List<Level> levels;

    private static ParkingLot INSTANCE;

    private ParkingLot() {
        this.id = UUID.randomUUID().toString();
        this.name = "Super Parking";
        this.levels = createLevels();
    }

    public static synchronized ParkingLot getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new ParkingLot();
        }
        return INSTANCE;
    }

    public void addLevel(int floor, int numberOfSpots) {
        this.levels.add(new Level(floor, numberOfSpots));
        System.out.println("Floor added successfully!");
    }

    public void parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return;
            }
        }
        System.out.println("No available Spot to park vehicle!");
    }

    public void releaseVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.releaseVehicle(vehicle)) {
                return;
            }
        }
        System.out.println("Fail to release vehicle!");
    }

    public void showAllSpots() {
        levels.forEach(Level::showAllSpots);
    }

    public void showAvailableSpots() {
        levels.forEach(Level::showAvailableSpots);
    }

    public void showAvailableSpots(Vehicle vehicle) {
        levels.forEach(level -> level.showAvailableSpots(vehicle.getVehicleType()));
    }

    private List<Level> createLevels() {
        List<Level> levels = new ArrayList<>();
        levels.add(new Level(0, 10));
        levels.add(new Level(1, 10));
        levels.add(new Level(2, 10));
        levels.add(new Level(3, 10));
        return levels;
    }
}

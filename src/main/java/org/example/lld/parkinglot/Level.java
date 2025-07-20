package org.example.lld.parkinglot;

import org.example.lld.parkinglot.vehicle.Vehicle;
import org.example.lld.parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Level {
    private final int floor;
    private final List<Spot> spots;

    private static final double spotsForBike = 0.5;
    private static final double spotsForCar = 0.4;

    public Level(int floor, int numberOfSpots) {
        this.floor = floor;
        this.spots = getParkingSpots(numberOfSpots);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Spot spot : spots) {
            if (Objects.nonNull(spot) && spot.isAvailable() && spot.getVehicleType().equals(vehicle.getVehicleType())) {
                spot.parkVehicle(vehicle);
                System.out.println("vehicle parked to floor " + floor + " & spot with id " + spot.getId());
                return true;
            }
        }
        return false;
    }

    public boolean releaseVehicle(Vehicle vehicle) {
        for (Spot spot : spots) {
            if (Objects.nonNull(spot) && !spot.isAvailable() && spot.getVehicle().getId().equalsIgnoreCase(vehicle.getId())) {
                spot.releaseVehicle();
                System.out.println("Vehicle released!");
                return true;
            }
        }
        return false;
    }

    public void showAllSpots() {
        System.out.println("floor = " + floor);
        spots.forEach(System.out::println);
    }

    public void showAvailableSpots() {
        System.out.println("floor = " + floor);
        spots.stream()
                .filter(Spot::isAvailable)
                .forEach(System.out::println);
    }

    public void showAvailableSpots(VehicleType vehicleType) {
        System.out.println("floor = " + floor);
        spots.stream()
                .filter(spot -> spot.isAvailable() && vehicleType.equals(spot.getVehicleType()))
                .forEach(System.out::println);
    }

    private List<Spot> getParkingSpots(int numberOfSpots) {
        int bikeSpots = (int) (spotsForBike * numberOfSpots);
        int carSpots = (int) (spotsForCar * numberOfSpots);

        List<Spot> spotList = new ArrayList<>();
        for (int i = 1; i <= bikeSpots; i++) {
            spotList.add(new Spot("spot-" + i, VehicleType.MOTORCYCLE));
        }
        for (int i = bikeSpots + 1; i <= bikeSpots + carSpots; i++) {
            spotList.add(new Spot("spot-" + i, VehicleType.CAR));
        }
        for (int i = bikeSpots + carSpots + 1; i <= numberOfSpots; i++) {
            spotList.add(new Spot("spot-" + i, VehicleType.TRUCK));
        }
        return spotList;
    }

    public int getFloor() {
        return floor;
    }

    public List<Spot> getSpots() {
        return spots;
    }
}

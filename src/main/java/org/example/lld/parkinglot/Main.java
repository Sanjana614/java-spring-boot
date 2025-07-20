package org.example.lld.parkinglot;

import org.example.lld.parkinglot.vehicle.Bike;
import org.example.lld.parkinglot.vehicle.Car;
import org.example.lld.parkinglot.vehicle.Truck;
import org.example.lld.parkinglot.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(4, 10);
        parkingLot.addLevel(5, 20);

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new Bike("M1234");

        parkingLot.showAllSpots();

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.showAvailableSpots();

        // Unpark vehicle
        parkingLot.releaseVehicle(motorcycle);

        // Display updated availability
        parkingLot.showAvailableSpots();
    }
}

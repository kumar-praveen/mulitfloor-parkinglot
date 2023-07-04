package org.example.parkinglot;

import org.example.parkinglot.constant.VehicleType;
import org.example.parkinglot.entity.Address;
import org.example.parkinglot.entity.ParkingFloor;
import org.example.parkinglot.entity.ParkingLot;
import org.example.parkinglot.entity.Vehicle;
import org.example.parkinglot.service.RandomService;

import java.util.List;
import java.util.Scanner;

public class ParkingLotApplication {
    public static Vehicle getVehicle(Integer number, int type) {
        return new Vehicle(String.valueOf(number), getVehicleType(type));
    }

    private static VehicleType getVehicleType(int type) {
        if (type == 1) return VehicleType.BIKE;
        if (type == 2) return VehicleType.SUV;
        return VehicleType.BUS;
    }

    public static void main(String[] args) {
        System.out.println("Starting Parking lot service !!");

        List<ParkingFloor> floors = RandomService.getRandomFloorList();
        Address address = RandomService.getRandomAddress();
        ParkingLot parkingLot = new ParkingLot("Praveen Vehicle park", address, floors);

        int operation = 100;
        Scanner scn = new Scanner(System.in);
        while (operation > 0) {
            System.out.println("Enter vehicle number and type..");
            int number = scn.nextInt();
            int type = scn.nextInt();
            Vehicle vehicle = getVehicle(number, type);


            System.out.println("Enter 1 to park and 2 to remove...");
            int park = scn.nextInt();
            if (park == 1) {
                parkingLot.parkVehicle(vehicle);
            } else {
                parkingLot.removeVehicle(vehicle);
            }
            operation--;
        }
        scn.close();
    }
}
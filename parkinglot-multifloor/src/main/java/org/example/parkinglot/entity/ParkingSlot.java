package org.example.parkinglot.entity;

import lombok.Data;
import org.example.parkinglot.constant.SlotType;

@Data
public class ParkingSlot {
    private Integer id;
    private Boolean isAvailable;
    private Vehicle vehicle;
    private SlotType type;

    public ParkingSlot(Integer id, SlotType type) {
        this.id = id;
        this.type = type;
        this.isAvailable = true;
        this.vehicle = null;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }
}

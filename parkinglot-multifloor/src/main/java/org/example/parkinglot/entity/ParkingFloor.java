package org.example.parkinglot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.parkinglot.constant.SlotType;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class ParkingFloor {
    private String id;
    private HashMap<SlotType, ParkingSlot[]> slots;

    public ParkingSlot getAvailableSlot(SlotType type) {
        ParkingSlot[] currSlots = slots.get(type);
        for (int idx = 0; idx < currSlots.length; idx++) {
            if (currSlots[idx].getIsAvailable()) {
                return currSlots[idx];
            }
        }
        return null;
    }

    public ParkingSlot isVehiclePresent(Vehicle vehicle, SlotType type) {
        ParkingSlot[] currSlots = slots.get(type);
        for (int idx = 0; idx < currSlots.length; idx++) {
            if (!currSlots[idx].getIsAvailable() &&
                    vehicle.getNumber().equals(currSlots[idx].getVehicle().getNumber())) {
                return currSlots[idx];
            }
        }
        return null;
    }
}

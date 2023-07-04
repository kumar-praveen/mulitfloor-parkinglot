package org.example.parkinglot.service;

import org.example.parkinglot.constant.SlotType;
import org.example.parkinglot.constant.VehicleType;

public class VehicleToSlotTypeAdaptor {

    public static SlotType getSlotType(VehicleType type) {
        if (VehicleType.BIKE.equals(type)) {
            return SlotType.SMALL;
        }
        if (VehicleType.SUV.equals(type)) {
            return SlotType.MEDIUM;
        }
        return SlotType.LARGE;
    }
}

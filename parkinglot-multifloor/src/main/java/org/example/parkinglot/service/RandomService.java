package org.example.parkinglot.service;

import org.example.parkinglot.constant.SlotType;
import org.example.parkinglot.entity.Address;
import org.example.parkinglot.entity.ParkingFloor;
import org.example.parkinglot.entity.ParkingSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomService {
    public static Address getRandomAddress() {
        return new Address("Jabalpur", 486884);
    }

    private static ParkingSlot[] getRandomParkingSlot(SlotType slotType) {
        Random random = new Random();
        int totalSlot = random.nextInt(6) + 1;
        ParkingSlot[] slots = new ParkingSlot[totalSlot];
        for (int idx = 0; idx < totalSlot; idx++) {
            slots[idx] = new ParkingSlot(idx, slotType);
        }
        System.out.println(slotType + " has " + slots.length + " slots");
        return slots;
    }

    private static ParkingFloor getRandomFloor(int cnt) {
        HashMap<SlotType, ParkingSlot[]> slots = new HashMap<>();
        for (SlotType slotType : SlotType.values()) {
            slots.put(slotType, getRandomParkingSlot(slotType));
        }
        System.out.println("----------------------");
        return new ParkingFloor("Floor: " + cnt, slots);
    }

    public static List<ParkingFloor> getRandomFloorList() {
        List<ParkingFloor> floors = new ArrayList<>();
        System.out.println("Total floor: " + 3);
        for (int cnt = 1; cnt <= 3; cnt++) {
            floors.add(getRandomFloor(cnt));
        }
        return floors;
    }
}

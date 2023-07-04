package org.example.parkinglot.entity;

import lombok.Data;
import org.example.parkinglot.constant.SlotType;
import org.example.parkinglot.constant.VehicleType;
import org.example.parkinglot.service.PaymentService;
import org.example.parkinglot.service.TicketService;
import org.example.parkinglot.service.VehicleToSlotTypeAdaptor;

import java.util.List;

@Data
public class ParkingLot {
    private String name;
    private Address address;
    private List<ParkingFloor> floors;
    private TicketService ticketService;

    public ParkingLot(String name, Address address, List<ParkingFloor> floors) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        ticketService = new TicketService();
    }

    public void parkVehicle(Vehicle vehicle) {
        VehicleType type = vehicle.getType();
        ParkingSlot slot = isSlotAvailable(type);
        if (slot == null) {
            System.out.println("Sorry no slots available...");
            return;
        }
        Ticket ticket = ticketService.createTicket(vehicle, slot.getType());
        slot.addVehicle(vehicle);
        System.out.println("Successfully parked..");
        System.out.println("Ticket: " + ticket);
    }

    public void removeVehicle(Vehicle vehicle) {
        ParkingSlot slot = getVehicleLocation(vehicle);
        if (slot == null) {
            System.out.println("No such vehicle parked...");
            return;
        }
        Ticket ticket = ticketService.getTicket(vehicle);
        Double amount = PaymentService.getTotalCost(ticket);
        ticketService.removeTicket(vehicle);
        slot.removeVehicle();
        System.out.println("Total amount: " + amount);
        System.out.println("Removed successfully..");
    }

    private ParkingSlot isSlotAvailable(VehicleType vehicleType) {
        SlotType slotType = VehicleToSlotTypeAdaptor.getSlotType(vehicleType);
        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.getAvailableSlot(slotType);
            if (slot != null) {
                return slot;
            }
        }
        return null;
    }

    private ParkingSlot getVehicleLocation(Vehicle vehicle) {
        SlotType slotType = VehicleToSlotTypeAdaptor.getSlotType(vehicle.getType());
        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.isVehiclePresent(vehicle, slotType);
            if (slot != null) {
                return slot;
            }
        }
        return null;
    }
}

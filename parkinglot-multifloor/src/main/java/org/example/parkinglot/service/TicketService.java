package org.example.parkinglot.service;

import org.example.parkinglot.constant.SlotType;
import org.example.parkinglot.entity.Ticket;
import org.example.parkinglot.entity.Vehicle;

import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;

public class TicketService {
    private final HashMap<Vehicle, Ticket> tickets;

    public TicketService() {
        tickets = new HashMap<>();
    }

    public Ticket createTicket(Vehicle vehicle, SlotType slotType) {
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), Instant.now().getEpochSecond(), slotType);
        tickets.put(vehicle, ticket);
        return ticket;
    }

    public Ticket getTicket(Vehicle vehicle) {
        return tickets.get(vehicle);
    }

    public void removeTicket(Vehicle vehicle) {
        tickets.remove(vehicle);
    }
}

package org.example.parkinglot.service;

import org.example.parkinglot.constant.SlotType;
import org.example.parkinglot.entity.Ticket;

import java.time.Instant;

public class PaymentService {

    public static Double getTotalCost(Ticket ticket) {
        long timeTaken = Instant.now().getEpochSecond() - ticket.getCreatedAt();
        SlotType slotType = ticket.getType();
        if (SlotType.SMALL.equals(slotType)) {
            return (timeTaken * 0.24) / (60 * 100);
        } else if (SlotType.MEDIUM.equals(slotType)) {
            return (timeTaken * 0.50) / (60 * 100);
        }
        return (timeTaken * 0.80) / (60 * 100);
    }
}

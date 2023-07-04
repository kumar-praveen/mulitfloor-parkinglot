package org.example.parkinglot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.parkinglot.constant.SlotType;

@Data
@AllArgsConstructor
public class Ticket {
    private String id;
    private Long createdAt;
    private SlotType type;
}

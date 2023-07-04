package org.example.parkinglot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.parkinglot.constant.VehicleType;

@Data
@AllArgsConstructor
public class Vehicle {
    private String number;
    private VehicleType type;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Vehicle vehicle = (Vehicle) obj;
        return this.getNumber().equals(vehicle.getNumber());
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.number);
    }
}

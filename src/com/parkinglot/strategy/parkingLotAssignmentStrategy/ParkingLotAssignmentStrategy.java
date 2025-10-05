package com.parkinglot.strategy.parkingLotAssignmentStrategy;

import com.parkinglot.ParkingFloor;
import com.parkinglot.ParkingSlot;
import com.parkinglot.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingLotAssignmentStrategy {
    Optional<ParkingSlot> parkVehicle(List<ParkingFloor> parkingFloorList, Vehicle vehicle);
}

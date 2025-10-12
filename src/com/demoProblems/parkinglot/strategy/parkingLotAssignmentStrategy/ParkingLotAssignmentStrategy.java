package com.demoProblems.parkinglot.strategy.parkingLotAssignmentStrategy;

import com.demoProblems.parkinglot.ParkingFloor;
import com.demoProblems.parkinglot.ParkingSlot;
import com.demoProblems.parkinglot.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingLotAssignmentStrategy {
    Optional<ParkingSlot> parkVehicle(List<ParkingFloor> parkingFloorList, Vehicle vehicle);
}

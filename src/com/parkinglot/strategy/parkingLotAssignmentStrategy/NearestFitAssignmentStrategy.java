package com.parkinglot.strategy.parkingLotAssignmentStrategy;

import com.parkinglot.ParkingFloor;
import com.parkinglot.ParkingSlot;
import com.parkinglot.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestFitAssignmentStrategy implements ParkingLotAssignmentStrategy {
    @Override
    public Optional<ParkingSlot> parkVehicle(List<ParkingFloor> parkingFloorList, Vehicle vehicle){
        for(ParkingFloor parkingFloor: parkingFloorList){
            for(ParkingSlot parkingSlot: parkingFloor.getParkingSlotList()){
                if(parkingSlot.getAvailable() && parkingSlot.getVehicleType() == vehicle.getVehicleType())
                    return Optional.of(parkingSlot);
            }
        }
        return Optional.empty();
    }
}

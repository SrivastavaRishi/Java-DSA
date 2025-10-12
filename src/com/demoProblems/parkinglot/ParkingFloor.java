package com.demoProblems.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final List<ParkingSlot> parkingSlotList;

    public ParkingFloor(){
        this.parkingSlotList = new ArrayList<>();
    }

    public void addParkingSlot(ParkingSlot parkingSlot){
        parkingSlotList.add(parkingSlot);
    }

    public List<ParkingSlot> getParkingSlotList(){
        return parkingSlotList;
    }
}

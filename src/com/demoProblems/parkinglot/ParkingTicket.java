package com.demoProblems.parkinglot;

import java.util.Date;

public class ParkingTicket {
    private final Vehicle vehicle;
    private final ParkingSlot parkingSlot;
    private final Date startTime;
    private Date endTime;

    public ParkingTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.startTime = new Date();
    }

    public void exitTicket(){
        this.endTime = new Date();
    }

    public Date getStartTime() {
        return startTime;
    }

    @Override
    public String toString(){
        if(endTime == null){
            return String.format("Entry Ticket for vehicle no : %s, slot : %s, from : %s",
                    vehicle.getRegistrationNumber(),
                    parkingSlot.getName(), startTime.toString());
        }
        return String.format("Exit Ticket for vehicle no : %s, slot : %s, from : %s, to : %s",
            vehicle.getRegistrationNumber(),
                parkingSlot.getName(), startTime.toString(), endTime.toString());
    }
}

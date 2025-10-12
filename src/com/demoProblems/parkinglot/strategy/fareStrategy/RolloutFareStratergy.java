package com.parkinglot.strategy.fareStrategy;

import com.parkinglot.ParkingTicket;
import com.parkinglot.VehicleType;

import java.util.Date;

public class RolloutFareStratergy implements FareStratergy {
    private static final int timeMultiplier = 50; // Rs 50/hour
    @Override
    public double calculateFare(ParkingTicket parkingTicket){
        var parkedSince = parkingTicket.getStartTime();
        long currTime = System.currentTimeMillis();
        long timeElapsedInMins = (currTime - parkedSince.getTime())/(1000 * 60);
        long timeElapsedInHour = Math.floorDiv(timeElapsedInMins, 60);
        return timeMultiplier * timeElapsedInHour;
    }
}

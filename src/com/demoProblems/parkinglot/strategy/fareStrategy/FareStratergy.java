package com.demoProblems.parkinglot.strategy.fareStrategy;

import com.demoProblems.parkinglot.ParkingTicket;

public interface FareStratergy {
    double calculateFare(ParkingTicket parkingTicket);
}

package com.parkinglot.strategy.fareStrategy;

import com.parkinglot.ParkingTicket;

public interface FareStratergy {
    double calculateFare(ParkingTicket parkingTicket);
}

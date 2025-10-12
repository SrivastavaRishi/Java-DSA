package com.demoProblems.parkinglot;

import com.demoProblems.parkinglot.strategy.fareStrategy.FareStratergy;
import com.demoProblems.parkinglot.strategy.fareStrategy.RolloutFareStratergy;
import com.demoProblems.parkinglot.strategy.parkingLotAssignmentStrategy.NearestFitAssignmentStrategy;
import com.demoProblems.parkinglot.strategy.parkingLotAssignmentStrategy.ParkingLotAssignmentStrategy;
import com.demoProblems.parkinglot.strategy.payment.CreditCardPayment;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        FareStratergy fareStratergy = new RolloutFareStratergy();
        ParkingLotAssignmentStrategy parkingLotAssignmentStrategy = new NearestFitAssignmentStrategy();
        ParkingLot parkingLot = ParkingLot.getInstance(fareStratergy, parkingLotAssignmentStrategy);

        // SETUP PART ......

        ParkingSlot parkingSlot1 = new ParkingSlot("A-1", VehicleType.BIKE);
        ParkingSlot parkingSlot2 = new ParkingSlot("A-2", VehicleType.CAR);
        ParkingSlot parkingSlot3 = new ParkingSlot("B-12", VehicleType.CAR);
        ParkingSlot parkingSlot4 = new ParkingSlot("B-10", VehicleType.BIKE);
        ParkingSlot parkingSlot5 = new ParkingSlot("D-101", VehicleType.TRUCK);
        ParkingSlot parkingSlot6 = new ParkingSlot("E-2", VehicleType.CAR);
        ParkingSlot parkingSlot7 = new ParkingSlot("E-1", VehicleType.BIKE);

        ParkingFloor floor1 = new ParkingFloor();
        ParkingFloor floor2 = new ParkingFloor();
        ParkingFloor floor3 = new ParkingFloor(); // floor3 is not available
        ParkingFloor floor4 = new ParkingFloor();
        ParkingFloor floor5 = new ParkingFloor();

        floor1.addParkingSlot(parkingSlot1);
        floor1.addParkingSlot(parkingSlot2);
        floor2.addParkingSlot(parkingSlot3);
        floor2.addParkingSlot(parkingSlot4);
        floor4.addParkingSlot(parkingSlot5);
        floor5.addParkingSlot(parkingSlot6);
        floor5.addParkingSlot(parkingSlot7);

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);
        parkingLot.addFloor(floor3);
        parkingLot.addFloor(floor4);
        parkingLot.addFloor(floor5);


        // SETUP DONE, APPLICATION UP for customers.
        Optional<ParkingTicket> parkingTicket = parkingLot.parkVehicle("RJ07-1234", VehicleType.CAR);
        System.out.println(parkingTicket);

        Optional<ParkingTicket> parkingTicket2 = parkingLot.parkVehicle("RJ07-1211", VehicleType.TRUCK);
        System.out.println(parkingTicket2);

        Optional<ParkingTicket> parkingTicket3 = parkingLot.parkVehicle("RJ07-1212", VehicleType.TRUCK);
        System.out.println(parkingTicket3);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(parkingLot.getFare("RJ07-1234"));

        parkingLot.releaseVehicle("RJ07-1234", new CreditCardPayment());

        System.out.println("Shutting down !!");
    }
}

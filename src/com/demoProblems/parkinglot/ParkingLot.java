package com.demoProblems.parkinglot;

import com.demoProblems.parkinglot.strategy.fareStrategy.FareStratergy;
import com.demoProblems.parkinglot.strategy.parkingLotAssignmentStrategy.ParkingLotAssignmentStrategy;
import com.demoProblems.parkinglot.strategy.payment.PaymentStrategy;

import java.util.*;

public class ParkingLot {
    private final List<ParkingFloor>parkingFloorList;
    private final FareStratergy fareStratergy;
    private final ParkingLotAssignmentStrategy parkingLotAssignmentStrategy;
    private final Map<String, ParkingTicket> vehicleToParkingTicketMap;

    private ParkingLot(FareStratergy fareStratergy, ParkingLotAssignmentStrategy parkingLotAssignmentStrategy){
        this.parkingFloorList = new ArrayList<>();
        this.fareStratergy = fareStratergy;
        this.parkingLotAssignmentStrategy = parkingLotAssignmentStrategy;
        this.vehicleToParkingTicketMap = new HashMap<>();
    }

    private static ParkingLot instance;

    public static ParkingLot getInstance(FareStratergy fareStratergy, ParkingLotAssignmentStrategy parkingLotAssignmentStrategy){
        if(instance == null){
            instance = new ParkingLot(fareStratergy, parkingLotAssignmentStrategy);
        } else{
            System.out.println("Instance is already initialized !!");
        }
        return instance;
    }

    public void addFloor(ParkingFloor parkingFloor){
        parkingFloorList.add(parkingFloor);
    }

    public Optional<ParkingTicket> parkVehicle(String vehicleRegNo, VehicleType vehicleType){
        Vehicle vehicle = new Vehicle(vehicleRegNo, vehicleType);
        Optional<ParkingSlot> parkingSlot = parkingLotAssignmentStrategy.parkVehicle(parkingFloorList, vehicle);
        if(parkingSlot.isPresent()){
            ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSlot.get());
            vehicleToParkingTicketMap.put(vehicleRegNo, parkingTicket);
            parkingSlot.get().changeAvailability();
            return Optional.of(parkingTicket);
        }
        return Optional.empty();
    }

    public double getFare(String vehicleRegNo){
        if(!vehicleToParkingTicketMap.containsKey(vehicleRegNo)){
            System.out.println("Please check the vehicle Reg no again !!");
        }
        ParkingTicket parkingTicket = vehicleToParkingTicketMap.get(vehicleRegNo);
        return fareStratergy.calculateFare(parkingTicket);
    }

    public boolean releaseVehicle(String vehicleRegNo, PaymentStrategy paymentStrategy){
        /*
        * 1. Calculate Fare
        * 2. Do payment
        * 3. Update ParkingTicket endDate
        * */
        if(!vehicleToParkingTicketMap.containsKey(vehicleRegNo)){
            System.out.println("Please check the vehicle Reg no again !!");
        }
        try {
            ParkingTicket parkingTicket = vehicleToParkingTicketMap.get(vehicleRegNo);
            double fare = getFare(vehicleRegNo);
            paymentStrategy.doPayment(fare);
            parkingTicket.exitTicket();
            System.out.println(parkingTicket);
            return true; // success ...
        } catch (Exception e) {
            System.out.println("Exception occurred while execution : " + e);
        }
        return false;
    }
}

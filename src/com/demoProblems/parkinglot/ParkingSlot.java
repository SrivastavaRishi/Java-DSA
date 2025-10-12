package com.parkinglot;

public class ParkingSlot {
    private final String name; // A-21 B-11
    private final VehicleType vehicleType;
    private Boolean isAvailable;

    public ParkingSlot(String name, VehicleType vehicleType){
        this.name = name;
        this.vehicleType = vehicleType;
        isAvailable = true;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void changeAvailability(){
        isAvailable = !isAvailable;
    }

    public String getName() {
        return name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

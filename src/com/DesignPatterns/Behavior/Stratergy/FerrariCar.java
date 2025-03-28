package com.DesignPatterns.Behavior.Stratergy;


import com.DesignPatterns.Behavior.Stratergy.DriverStratergy.SportsDriveStratergy;

public class FerrariCar extends Vehicle{
    String model;
    FerrariCar(){
        super(new SportsDriveStratergy());
    }
}

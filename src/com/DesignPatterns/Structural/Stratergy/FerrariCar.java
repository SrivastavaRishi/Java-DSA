package com.DesignPatterns.Structural.Stratergy;


import com.DesignPatterns.Structural.Stratergy.DriverStratergy.SportsDriveStratergy;

public class FerrariCar extends Vehicle{
    String model;
    FerrariCar(){
        super(new SportsDriveStratergy());
    }
}

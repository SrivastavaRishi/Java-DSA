package com.DesignPatterns.Structural.Stratergy;


import com.DesignPatterns.Structural.Stratergy.DriverStratergy.DriveStratergy;

public class Vehicle {
    DriveStratergy driveStratergy;
    Vehicle(DriveStratergy stratergyObj){
        this.driveStratergy = stratergyObj;
    }
    public void drive(){
        driveStratergy.drive();
    }
}

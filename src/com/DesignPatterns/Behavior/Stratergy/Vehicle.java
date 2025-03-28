package com.DesignPatterns.Behavior.Stratergy;


import com.DesignPatterns.Behavior.Stratergy.DriverStratergy.DriveStratergy;

public class Vehicle {
    DriveStratergy driveStratergy;
    Vehicle(DriveStratergy stratergyObj){
        this.driveStratergy = stratergyObj;
    }
    public void drive(){
        driveStratergy.drive();
    }
}

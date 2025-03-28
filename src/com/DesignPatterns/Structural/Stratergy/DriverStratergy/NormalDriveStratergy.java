package com.DesignPatterns.Structural.Stratergy.DriverStratergy;

public class NormalDriveStratergy implements DriveStratergy {
    @Override
    public void drive() {
        System.out.println("normal driving car");
    }
}

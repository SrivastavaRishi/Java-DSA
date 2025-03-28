package com.DesignPatterns.Structural.Stratergy;

import com.DesignPatterns.Structural.Stratergy.DriverStratergy.NormalDriveStratergy;

public class Maruti extends Vehicle{
    String model;
    Maruti(){
        super(new NormalDriveStratergy());
    }
}

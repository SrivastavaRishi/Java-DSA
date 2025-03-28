package com.DesignPatterns.Behavior.Stratergy;

import com.DesignPatterns.Behavior.Stratergy.DriverStratergy.NormalDriveStratergy;

public class Maruti extends Vehicle{
    String model;
    Maruti(){
        super(new NormalDriveStratergy());
    }
}

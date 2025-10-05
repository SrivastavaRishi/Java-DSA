package com.parkinglot.strategy.payment;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public boolean doPayment(double amount){
        System.out.println("Starting CC Payment for amount " + amount + "!!!");
        return true;
    }
}

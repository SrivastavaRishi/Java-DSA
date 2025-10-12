package com.parkinglot.strategy.payment;

public interface PaymentStrategy {
    boolean doPayment(double amount);
}

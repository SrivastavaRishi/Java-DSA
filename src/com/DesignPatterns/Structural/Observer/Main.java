package com.DesignPatterns.Structural.Observer;

public class Main {
    public static void main(String[] args) {
        StocksObservable iphoneObservable = new IphoneObservable();
        NotificationAlertObserver ob1 = new EmailAlertObserver("rishi@gmail.com", iphoneObservable);
        NotificationAlertObserver ob2 = new EmailAlertObserver("tarun@gmail.com", iphoneObservable);
        NotificationAlertObserver ob3 = new SmsAlertObserver("1234512345", iphoneObservable);
        iphoneObservable.add(ob1);
        iphoneObservable.add(ob2);
        iphoneObservable.add(ob3);
        iphoneObservable.setStockCount(10);
    }
}

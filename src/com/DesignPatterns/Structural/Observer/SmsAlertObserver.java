package com.DesignPatterns.Structural.Observer;

public class SmsAlertObserver implements NotificationAlertObserver{
    String mobile;
    StocksObservable observable;
    SmsAlertObserver(String mobile, StocksObservable observable){
        this.mobile = mobile;
        this.observable = observable;
    }
    public void update(){
        System.out.println("SMS triggered !!");
        // calls a third party API to send email notification
        // observable object will contain info about the product
    }
}
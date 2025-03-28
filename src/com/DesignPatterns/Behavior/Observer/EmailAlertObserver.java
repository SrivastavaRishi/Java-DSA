package com.DesignPatterns.Behavior.Observer;

public class EmailAlertObserver implements NotificationAlertObserver{
    String emailId;
    StocksObservable observable;
    EmailAlertObserver(String email, StocksObservable observable){
        this.emailId = email;
        this.observable = observable;
    }
    public void update(){
        System.out.println("Email triggered !!");
        // calls a third party API to send email notification
        // observable object will contain info about the product
    }
}

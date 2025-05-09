package com.DesignPatterns.Behavior.Observer;

public interface StocksObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int newStock);
    public int getStockCount();
}

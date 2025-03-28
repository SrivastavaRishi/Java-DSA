package com.DesignPatterns.Structural.Observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StocksObservable{
    public List<NotificationAlertObserver>obList = new ArrayList<>();
    public int stockCnt = 0;
    public void add(NotificationAlertObserver ob){
        obList.add(ob);
    }
    public void remove(NotificationAlertObserver ob){
        obList.remove(ob);
    }
    public int getStockCount(){
        return stockCnt;
    }
    public void setStockCount(int newStock){
        if(stockCnt == 0){
            notifySubscribers();
        }
        stockCnt += newStock;
    }
    public void notifySubscribers(){
        for(NotificationAlertObserver obs: obList){
            obs.update();
        }
    }
}

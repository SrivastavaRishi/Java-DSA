package com.DesignPatterns.Behavior.Iterator;

public class Book {
    private final int price;
    private final String name;

    public Book(int price, String name){
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Price " + price + " Name :: " + name;
    }
}

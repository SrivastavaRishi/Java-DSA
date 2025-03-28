package com.Demo.InheritanceDemo;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Square();
        shape.fun();
        Shape.staticMethod();

        Square sq = new Square();
        sq.fun2();
        Square.staticMethod();

        System.out.println(sq.toString());
    }
}

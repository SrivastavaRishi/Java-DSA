package com.Demo.InheritanceDemo;

public class Square extends Shape{
    @Override
    public void fun(){
        System.out.println("Inside square class");
        fun2();
    }

    public void fun2(){
        System.out.println("Inside fun2 !!");
    }
}

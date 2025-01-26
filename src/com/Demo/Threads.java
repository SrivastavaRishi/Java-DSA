package com.Demo;

class A extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Hello !!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class B extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Hi !!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Threads {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();
    }
}

package com.DataStructure.concurrency;

import java.util.function.IntConsumer;

public class MyThread extends Thread{
    @Override
    public void run(){

//        IntConsumer printNumber)

        for(int i=0;i<10;i++){
            try{
                System.out.println(Thread.currentThread().threadId() + "::" + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

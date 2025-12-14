package com.DataStructure.concurrency;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private final int n;
    private int curr;
    private volatile boolean flag;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.curr = 0;
        this.flag = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        System.out.println("Zero start:: " + Thread.currentThread().getName());
        while(curr <= n){
            if(flag) {
                printNumber.accept(0);
                flag = false;
                if(curr == 0)curr++;
                notifyAll();
            }
            else {
                wait();
            }
        }
        System.out.println("Zero end:: " + Thread.currentThread().getName());
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        System.out.println("even start:: " + Thread.currentThread().getName());
        while(curr <= n) {
            if (!flag && curr % 2 == 0) {
                printNumber.accept(curr);
                curr++;
                flag = true;
                notifyAll();
            } else {
                wait();
            }
        }
        System.out.println("even end:: " + Thread.currentThread().getName());
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        System.out.println("odd start:: " + Thread.currentThread().getName());
        while(curr <= n) {
            if (!flag && curr % 2 == 1) {
                printNumber.accept(curr);
                curr++;
                flag = true;
                notifyAll();
            } else {
                wait();
            }
        }
        System.out.println("odd end:: " + Thread.currentThread().getName());
    }
}

public class Runner {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(8);
        IntConsumer pn = ((x) -> {
            System.out.println("Value is " + x);
        });
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(pn);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(pn);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(pn);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

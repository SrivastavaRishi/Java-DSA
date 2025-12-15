package com.DataStructure.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

// solution 1: using threads and simple wait/notifyAll
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

// solution2: using semaphores
class ZeroEvenOdd1 {
    private final int n;
    private final Semaphore zero = new Semaphore(1);
    private final Semaphore odd = new Semaphore(0);
    private final Semaphore even = new Semaphore(0);

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        System.out.println("Zero start:: " + Thread.currentThread().getName());
        for(int i=1;i<=n;i++){
            zero.acquire();
            printNumber.accept(0);
            if(i%2==0){
                even.release();
            } else
                odd.release();
        }
        System.out.println("Zero end:: " + Thread.currentThread().getName());
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        System.out.println("even start:: " + Thread.currentThread().getName());
        for(int i=2;i<=n;i+=2){
                even.acquire();
                printNumber.accept(i);
                zero.release();
        }
        System.out.println("even end:: " + Thread.currentThread().getName());
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        System.out.println("odd start:: " + Thread.currentThread().getName());
        for(int i=1;i<=n;i+=2){
                odd.acquire();
                printNumber.accept(i);
                zero.release();
        }
        System.out.println("odd end:: " + Thread.currentThread().getName());
    }
}

public class Runner {
    public static void main(String[] args) {
//        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(8);
//        IntConsumer pn = ((x) -> {
//            System.out.println("Value is " + x);
//        });
//        Thread t1 = new Thread(() -> {
//            try {
//                zeroEvenOdd.zero(pn);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            try {
//                zeroEvenOdd.even(pn);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        Thread t3 = new Thread(() -> {
//            try {
//                zeroEvenOdd.odd(pn);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        t1.start();
//        t2.start();
//        t3.start();




        ZeroEvenOdd1 zeroEvenOdd = new ZeroEvenOdd1(8);
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

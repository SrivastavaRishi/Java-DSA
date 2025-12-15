package com.DataStructure.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzbuzz = new Semaphore(0);
    private final Semaphore num = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if(i % 5 == 0)continue;
            fizz.acquire();
            // if (i % 5 == 0) {
            // fizzbuzz.release();
            // continue;
            // } else {
            printFizz.run();
            num.release();
            // }
            // fizz.release();
        }
        // System.out.println("fizz shutdown !!");
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if(i % 3 == 0)continue;
            buzz.acquire();
            printBuzz.run();
            num.release();
        }
        // System.out.println("buzz shutdown !!");
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzbuzz.acquire();
            printFizzBuzz.run();
            num.release();
        }
        // System.out.println("fizzbuzz shutdown !!");
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            // System.out.println("Value of i is " + i);
            num.acquire();
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzbuzz.release();
                } else if (i % 3 == 0) {
                    fizz.release();
                } else {
                    buzz.release();
                }
            } else {
                printNumber.accept(i);
                num.release();
            }
        }
        ;
        // System.out.println("Num shutdown !!");
    }
}

public class FizzBuzzImpl{
    public static void main(String[] args) {
    }
}

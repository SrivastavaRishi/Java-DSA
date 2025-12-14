package com.DataStructure.concurrency;

import java.util.concurrent.*;

class SyncClass {
    int cnt;
//    public void increment(){
//        cnt++;
//    }
    public synchronized void increment(){
        cnt++;
    }
    public int getCount(){
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SyncClass sc = new SyncClass();

        var es = Executors.newFixedThreadPool(5);

        Runnable task = () -> {
          for(int i=0;i<10;i++)
              sc.increment();
        };

        for (int t = 0; t < 100; t++) {
            es.execute(() -> {
                for (int i = 0; i < 100; i++) {
                    sc.increment();
                }
            });
        }

        es.shutdown();
        es.awaitTermination(15, TimeUnit.SECONDS);


        int expected = 10000;
        int actual = sc.getCount();

        System.out.println("Expected = " + expected);
        System.out.println("Actual   = " + actual);




//        Thread t1 = new MyThread();
//        Thread t2 = new MyThread();
//        t1.start();
//        t2.start();

//        Runnable r1 = new RunnableThread();
//        Runnable r2 = new RunnableThread();
//
//        new Thread(r1).start();
//        new Thread(r2).start();

//        Runnable task = (() -> {
//            for(int i=0;i<5;i++){
//                try {
//                    System.out.println("i is " + i + ":: " + Thread.currentThread().threadId());
//                    Thread.sleep(1000);
//                } catch (InterruptedException e){
//                    throw new RuntimeException();
//                }
//            }
//        });
//
//        new Thread(task).start();
//        new Thread(task).start();

//        Callable<String> callable = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "";
//            }
//        };
//
//        Callable<String> callable1 = (() -> System.getenv("key"));

//        try (ExecutorService es = Executors.newFixedThreadPool(3)) {
//            for (int i = 0; i < 8; i++) {
//                es.execute(() -> {
//                    try {
//                        Thread.sleep(1500);
//                        System.out.println("Thread is :: " + Thread.currentThread().getName());
//                    } catch (InterruptedException e){
//                        throw new RuntimeException();
//                    }
//                });
//            }
//        }

//        try (ScheduledExecutorService es = Executors.newScheduledThreadPool(2)){
//            es.schedule(() -> System.out.println("hello world"), 10, TimeUnit.SECONDS);
//        }



    }
}

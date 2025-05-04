package com.CacheProject;
import java.util.*;
import java.util.concurrent.CompletableFuture;

enum Operation {
    GET, SET, DELETE, CLEAR
}

public class CacheStore<K, V> {
    private static final CacheStore<?, ?> instance = new CacheStore<>();
    private final Map<K, V> store = new HashMap<>();
    private final Queue<Task<K, V>> taskQueue = new LinkedList<>();
    private final ReadWriteLock lock = new ReadWriteLock();
    private final Object queueLock = new Object();
    private static final int THREAD_COUNT = 3;

    private CacheStore() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(this::worker).start();
        }
    }

    @SuppressWarnings("unchecked")
    public static synchronized <K, V> CacheStore<K, V> getInstance() {
        return (CacheStore<K, V>) instance;
    }

    public void set(K key, V value) {
        submit(new Task<>(Operation.SET, key, value));
    }

    public V get(K key) {
        CompletableFuture<V> future = new CompletableFuture<>();
        submit(new Task<>(Operation.GET, key, null, future));
        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get value", e);
        }
    }

    public void delete(K key) {
        submit(new Task<>(Operation.DELETE, key, null));
    }

    public void clear() {
        submit(new Task<>(Operation.CLEAR, null, null));
    }

    private void submit(Task<K, V> task) {
        synchronized (queueLock) {
            taskQueue.offer(task);
            queueLock.notifyAll();
        }
    }

    private void worker() {
        while (true) {
            Task<K, V> task;
            synchronized (queueLock) {
                while (taskQueue.isEmpty()) {
                    try {
                        queueLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                task = taskQueue.poll();
            }
            try {
                handle(task);
            } catch (Exception e) {
                System.out.println("Error message : " + e.getMessage());
            }
        }
    }


    private void handle(Task<K, V> task) throws InterruptedException {
        switch (task.operation) {
            case GET -> {
                lock.lockRead();
                V result = store.get(task.key);
                System.out.println("GET [" + task.key + "] -> " + result);
                if (task.future != null) {
                    task.future.complete(result);
                }
//                Thread.sleep(1000);
                lock.unlockRead();
            }
            case SET -> {
                lock.lockWrite();
                store.put(task.key, task.value);
                System.out.println("SET [" + task.key + "] = " + task.value);
//                Thread.sleep(2000);
                lock.unlockWrite();
            }
            case DELETE -> {
                lock.lockWrite();
                store.remove(task.key);
                System.out.println("DELETE [" + task.key + "]");
//                Thread.sleep(2000);
                lock.unlockWrite();
            }
            case CLEAR -> {
                lock.lockWrite();
                store.clear();
                System.out.println("CLEAR cache");
//                Thread.sleep(4000);
                lock.unlockWrite();
            }
        }
    }
}

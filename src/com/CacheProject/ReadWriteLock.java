package com.CacheProject;

public class ReadWriteLock {
    private int readers = 0;
    private boolean isWriting = false;

    public synchronized void lockRead() throws InterruptedException {
        while (isWriting) wait();
        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        if (readers == 0) notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        while (readers > 0 || isWriting) wait();
        isWriting = true;
    }

    public synchronized void unlockWrite() {
        isWriting = false;
        notifyAll();
    }
}

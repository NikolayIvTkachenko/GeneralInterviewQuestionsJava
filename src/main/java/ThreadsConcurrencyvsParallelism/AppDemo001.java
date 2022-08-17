package ThreadsConcurrencyvsParallelism;

import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock - one thread at a time
//ReadWriteLock - one writer thread at a time OR Multiple reader threads at a time

public class AppDemo001 {

    private static ReentrantLock lock = new ReentrantLock();

    private static void accessResource() {
        lock.lock();
        try{

        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> accessResource());
        t1.start();

        Thread t2 = new Thread(() -> accessResource());
        t2.start();

        Thread t3 = new Thread(() -> accessResource());
        t3.start();

        Thread t4 = new Thread(() -> accessResource());
        t4.start();

        Thread t5 = new Thread(() -> accessResource());
        t5.start();


    }


}

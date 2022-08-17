package ThreadsConcurrencyvsParallelism;


import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//ReentrantLock - one thread at a time
//ReadWriteLock - one writer thread at a time OR Multiple reader threads at a time

//ReadLock is being used by n threads
//WriteLock is being used by 1 thread

public class AppDemo002 {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private static void readResource(){
        readLock.lock();
        // view the resource
        readLock.unlock();
    }

    private static void writeResource(){
        writeLock.lock();
        // update the resource
        writeLock.unlock();
    }



    public static void main(String[] args) {

        Thread t1 = new Thread(() -> readResource());
        t1.start();

        Thread t2 = new Thread(() -> readResource());
        t2.start();

        Thread t3 = new Thread(() -> writeResource());
        t3.start();

        Thread t4 = new Thread(() -> writeResource());
        t4.start();

        Thread t5 = new Thread(() -> writeResource());
        t5.start();


    }
}

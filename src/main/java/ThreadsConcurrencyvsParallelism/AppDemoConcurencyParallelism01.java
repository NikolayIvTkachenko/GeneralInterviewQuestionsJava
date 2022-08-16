package ThreadsConcurrencyvsParallelism;

//Parallelism is about doing lot of things at once
//Concurrency is about dealing with lot of things at once
// - Locks / synchronized
// - Atomic classes
// - Concurrent data structures (ConcurrentHashMap, BlockingQueue)
// - CompletableFuture
// - CountdownLatch/Phaser/CyclicBarrier/Semaphore


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class AppDemoConcurencyParallelism01 {
    static int ticketAvailable = 1000;


    public static void main(String[] args) throws InterruptedException {

        //Parallelism
        ExecutorService es = Executors.newFixedThreadPool(4);
//        es.submit(() -> processDoing(user1));
//        es.submit(() -> processDoing(user2));
//        heavyCalculations();



        //Concurrency
        ReentrantLock locker = new ReentrantLock();
        new Thread(() -> {
            //some code
            locker.lock();
            if(ticketAvailable > 0){
                //bookTicket();
                ticketAvailable--;
            }
            locker.unlock();
        }).start();
        new Thread(() -> {
            //some code
            locker.lock();
            if(ticketAvailable > 0){
                //bookTicket();
                ticketAvailable--;
            }
            locker.unlock();
        }).start();

        Thread.sleep(5000);



    }

}

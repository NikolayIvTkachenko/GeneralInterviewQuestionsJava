package TreadsAndMultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppThreadsDemo0004 {

    public static void main(String[] args) {

        // 1. FixedThreadPool
        // 2. CachedThreadPool
        // 3. ScheduledThreadPool
        // 4. SingleThreadExecutor

        // 1. FixedThreadPool
        //create the pool
//        ExecutorService service = Executors.newFixedThreadPool(10);
//
//        //submit the task for executor
//        for(int i = 0; i < 100; i++){
//            service.execute(new Task());
//        }

        // 2. CachedThreadPool
        //create the pool
         ExecutorService serviceCached = Executors.newCachedThreadPool();

        //submit the task for executor
        for(int i = 0; i < 100; i++){
            serviceCached.execute(new Task());
        }

        // 3. ScheduledThreadPool
        ScheduledExecutorService serviceSchedule = Executors.newScheduledThreadPool(10);

        //submit the task for executor
        for(int i = 0; i < 100; i++){
            serviceSchedule.schedule(new Task(), 10, TimeUnit.MILLISECONDS);
        }

        serviceSchedule.scheduleAtFixedRate(new TaskV2(), 15, 10, TimeUnit.SECONDS);
        serviceSchedule.scheduleWithFixedDelay(new TaskV2(), 20, 5, TimeUnit.SECONDS);


        // 4. SingleThreadExecutor
//        ExecutorService serviceSingle = Executors.newSingleThreadExecutor();
//
//        //submit the task for executor
//        for(int i = 0; i < 100; i++){
//            serviceSingle.execute(new Task());
//        }



        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }


    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }

    static class TaskV2 implements Runnable {
        @Override
        public void run() {
            System.out.println("SCHEDULER START Thread Name: " + Thread.currentThread().getName());
        }
    }

}

package ThreadsSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AppDemoSemaphore002 {

    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {



        ExecutorService executorService = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i -> executorService.execute(new Task()));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        //Thread.sleep(5000);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            //V 01
            //some processing
            semaphore.acquireUninterruptibly();

            //IO call to the slow service

            System.out.println("Thread Name: " + Thread.currentThread().getName()) ;
            semaphore.release();
            //rest of processing

            //V 02
//            //some processing
//            try {
//                semaphore.acquire();
//
//                //IO call to the slow service
//
//                System.out.println("Thread Name: " + Thread.currentThread().getName()) ;
//
//                semaphore.release();
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            //rest of processing
        }
    }

}

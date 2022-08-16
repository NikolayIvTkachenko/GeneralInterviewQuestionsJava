package ThreadsSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AppDemoSemaphore001 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i -> executorService.execute(new Task()));

        //executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);


    }

    static class Task implements Runnable {

        @Override
        public void run() {
            //some processing
            //IO call to the slow service
            //rest of processing
            System.out.println("Thread Name: " + Thread.currentThread().getName()) ;
        }
    }


}

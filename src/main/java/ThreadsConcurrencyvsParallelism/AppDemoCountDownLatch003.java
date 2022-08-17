package ThreadsConcurrencyvsParallelism;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppDemoCountDownLatch003 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(3);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));

        latch.await();

        System.out.println("All dependant service initialized");

    }

    public static class DependentService implements Runnable {

        private CountDownLatch latch;

        public DependentService(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Thread name: "+ Thread.currentThread().getName());
            latch.countDown();
        }
    }

}

package ThreadsConcurrencyvsParallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class AppDemoPhaser006 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(3);
        executorService.submit(new Task(phaser));
        executorService.submit(new Task(phaser));
        executorService.submit(new Task(phaser));

        Thread.sleep(3000);

        System.out.println("All dependant services initialized");

    }

    public static class Task implements Runnable {

        private Phaser phaser;

        public Task(Phaser phaser){
            this.phaser = phaser;
        }

        @Override
        public void run() {
            phaser.arriveAndAwaitAdvance(); //Similar to barrier.await()
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }



}

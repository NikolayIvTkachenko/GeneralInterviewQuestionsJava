package ThreadsConcurrencyvsParallelism;

//Phaser
//CountDownLatch
//CyclicBarrier
//plus more flexibility
//
//


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class AppDemoPhaser005 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(3);
        executorService.submit(new DependentService(phaser));
        executorService.submit(new DependentService(phaser));
        executorService.submit(new DependentService(phaser));

        phaser.awaitAdvance(1);

        System.out.println("All dependant services initialized");

    }

    public static class DependentService implements Runnable {

        private Phaser phaser;

        public DependentService(Phaser phaser){
            this.phaser = phaser;
        }

        @Override
        public void run() {
            phaser.arrive(); //Similar to countDown()
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }


}

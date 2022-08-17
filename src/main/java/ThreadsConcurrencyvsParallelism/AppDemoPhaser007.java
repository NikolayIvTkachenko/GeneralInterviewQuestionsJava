package ThreadsConcurrencyvsParallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class AppDemoPhaser007 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(1); //self-register

        executorService.submit(new Service(phaser));
        executorService.submit(new Service(phaser));

        phaser.arriveAndAwaitAdvance();
        phaser.bulkRegister(4);
    }


    public static class Service implements Runnable {

        private Phaser phaser;

        public Service(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            //Allow threads to register themselves

            phaser.register();
            //some operations
            phaser.arrive();
            //other operations

        }
    }


}

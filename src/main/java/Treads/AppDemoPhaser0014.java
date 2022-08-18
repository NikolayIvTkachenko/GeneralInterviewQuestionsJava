package Treads;

import java.util.concurrent.Phaser;

public class AppDemoPhaser0014 {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(2);

        new Washer(phaser);
        new Washer(phaser);

    }

    static class Washer extends Thread {
        Phaser phaser;

        public Washer(Phaser phaser) {
            //phaser.register();
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            //phaser.arriveAndAwaitAdvance();
            for(int i = 0; i<3; i++){
                System.out.println(getName() + " washing the car");
                phaser.arriveAndAwaitAdvance();
            }
        }
    }


}

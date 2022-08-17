package ThreadsConcurrencyvsParallelism;

import java.util.concurrent.*;

public class AppDemoCyclicBarrier004 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CyclicBarrier barrier = new CyclicBarrier(3);
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));

        Thread.sleep(2000);

    }


    public static class Task implements Runnable {

        private CyclicBarrier barrier;
        public Task(CyclicBarrier barrier) {this.barrier = barrier; }

        @Override
        public void run() {
            while(true){
                try{
                    barrier.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
                System.out.println("Thread name after barrier " + Thread.currentThread().getName());
                //send message to corresponding system

            }
        }
    }

}

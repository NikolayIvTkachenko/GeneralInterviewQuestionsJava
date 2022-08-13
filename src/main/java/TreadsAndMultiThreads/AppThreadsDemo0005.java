package TreadsAndMultiThreads;

import java.util.Random;
import java.util.concurrent.*;

public class AppThreadsDemo0005 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);

        //submit the tasks for execution
        Future<Integer> future = service.submit(new Task());

        //perform some unrelated operations
        // 1 sec
        Integer result = future.get();

        System.out.println("Thread Name: " + Thread.currentThread().getName());


    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }


}

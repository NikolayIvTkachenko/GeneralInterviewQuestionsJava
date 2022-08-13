package TreadsAndMultiThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class AppThreadsDemo0006 {

    public static void main(String[] args)  {

        //create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);

        //submit the tasks for execution
        Future<Integer> future = service.submit(new Task());

        //perform some unrelated operations
        // 1 sec
        try {
            Integer result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }

        //cancel the task
        future.cancel(false);

        //Returns true if task was cancelled
        future.isCancelled();

        //returns true is task is completed (successfully or otherwise)
        future.isDone();


        List<Future> allFutures = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            Future<Integer> futureV2 = service.submit(new Task());
            allFutures.add(futureV2);
        }

        for (int i = 0; i < 100; i++) {
            Future<Integer> futureResult = allFutures.get(i);
            try {
                Integer result = futureResult.get();
                System.out.println("Result of future #" + i + "=" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e){
                e.printStackTrace();
                System.out.println("Couldn't complete task before timeout");
            }
        }

        System.out.println("Thread Name: " + Thread.currentThread().getName());


    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

}

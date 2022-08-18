package Treads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AppDemoFutureTask009 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new TestCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    static class TestCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; i++, j++){
                Thread.sleep(300);
            }
            return j;

        }
    }


}

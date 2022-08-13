package TreadsAndMultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppThreadsDemo0003 {

    public static void main(String[] args) {

        //get count if available cores
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Core Count: " + coreCount);

        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        //submit the tasks for execution
        for(int i = 0; i < 100; i++) {
            service.execute(new CpuIntensiveTask());
        }

    }

    static class CpuIntensiveTask implements Runnable {

        @Override
        public void run() {
            // some CPU intensive operations


        }
    }


}

package Treads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class AppDemoForkJoin016 {

    static long numOfoperations = 10_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println("------------");
        System.out.println("numOfoperations = " + numOfoperations);
        System.out.println("numOfThreads = " + numOfThreads);




        Date startDate = new Date();
        System.out.println("Start: " + startDate);

        //Devide between 8 thread
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        System.out.println(pool.invoke(new TestFork(0, numOfoperations)));

        //Long time witj ine thread
//        long j = 0;
//        for(long i = 0; i < numOfoperations; i++){
//            j += i;
//        }
//        System.out.println(j);



        Date endDate = new Date();
        System.out.println("End: " + endDate);

        Date durations = new Date(endDate.getTime() - startDate.getTime());

        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
        String strDurations = "Duration date: " + dt.format(durations);
        System.out.println(strDurations);
        Long durationLong = endDate.getTime() - startDate.getTime();
        String strDurationsLong = "Duration millesecunds: " + durationLong;
        System.out.println(strDurationsLong);

    }


    static class TestFork extends RecursiveTask<Long> {

        long from, to;

        public TestFork(long from, long to){
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= numOfoperations / numOfThreads) {

                long j = 0;
                for(long i = from; i < to; i++){
                    j += i;
                }
                return j;
            } else {
                long middle = (to + from) / 2;

                TestFork firstHalf = new TestFork(from, middle);
                firstHalf.fork();

                TestFork secondHalf = new TestFork(middle + 1, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;

            }
        }
    }

}

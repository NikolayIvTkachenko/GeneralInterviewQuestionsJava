package Treads;

import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AppDemoThreadLocalRandom0018 {
    public static void main(String[] args) throws InterruptedException {

        //Not use in multithreeds app Math.Random
        System.out.println(Math.random());

        //For multithreads application
        System.out.println(ThreadLocalRandom.current().nextInt());

        //Thread.sleep(1_000);
        //TimeUnit

        System.out.println(TimeUnit.DAYS.toMillis(15));

        //Thread.sleep();

    }


}

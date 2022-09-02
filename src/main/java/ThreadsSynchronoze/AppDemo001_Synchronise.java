package ThreadsSynchronoze;

import java.util.concurrent.atomic.AtomicInteger;

public class AppDemo001_Synchronise {

    public static void main(String[] args) {

        Count count = new Count();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 1_000_000_000; i++){
            count.count();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime);
        System.out.println("endTime = " + endTime);
        long delta = endTime - startTime;
        System.out.println("delta = " + delta);
    }

    static class Count {
        volatile int i;
        //AtomicInteger atomicInteger = new AtomicInteger(0);
        //int i;
        synchronized void count() {
            i++;
            //atomicInteger.incrementAndGet();
        }
    }

}

// General
//startTime = 1662109734838
//endTime = 1662109734898
//delta = 60

// General + volatile
//startTime = 1662109905691
//endTime = 1662109910568
//delta = 4877

// General + AtomicInteger
//startTime = 1662110568908
//endTime = 1662110574115
//delta = 5207


//synchronized
//startTime = 1662110715185
//endTime = 1662110732088
//delta = 16903

//synchronized + volatile
//startTime = 1662110787267
//endTime = 1662110807180
//delta = 19913
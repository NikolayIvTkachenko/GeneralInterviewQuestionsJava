package Treads;

public class AppDemoThreadsBad003 {

    static int i;

    public static void main(String[] args) throws InterruptedException {
        for(int j = 0; j < 100_000; j++) {
            new MyThread().start();
        }
        Thread.sleep(2000);
        System.out.println(i);
    }


    static class MyThread extends Thread {

        @Override
        public void run() {
            i++; //not atomarn operation
            //int k = i + 1;
            //i = k;
        }
    }

}

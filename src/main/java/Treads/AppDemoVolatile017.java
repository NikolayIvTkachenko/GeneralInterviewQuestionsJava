package Treads;

public class AppDemoVolatile017 {

    volatile static int i = 0;

    public static void main(String[] args) {

        new TestThreadWrite().start();
        new TestThreadRead().start();

    }

    static class TestThreadWrite extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }


    static class TestThreadRead extends Thread {
        @Override
        public void run() {

            int localVar = i;
            while (localVar < 5){
                if(localVar != i){
                    System.out.println("new value of i is " + i);
                    localVar = i;
                }
            }
        }
    }


}

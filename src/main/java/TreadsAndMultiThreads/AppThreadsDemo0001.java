package TreadsAndMultiThreads;

public class AppThreadsDemo0001 {

    public static void main(String[] args) {

        //1 Java Thread = 1 OS Thread

        Thread thread01 = new Thread(new Task());
        thread01.start();

        System.out.println("Thread Name: " + Thread.currentThread().getName());

        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new Task());
            thread.start();
        }

    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }

}

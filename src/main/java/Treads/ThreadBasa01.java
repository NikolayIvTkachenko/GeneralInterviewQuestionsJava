package Treads;

public class ThreadBasa01 {

    public static void main(String[] args) throws InterruptedException {

        TestThread005 testThread005 = new TestThread005();
        testThread005.start();

        //Thread.yield();//случайным образом будет запускаться либо main, либо Thread-0
        testThread005.join();
        System.out.println(Thread.currentThread().getName());
    }

}

class TestThread005 extends Thread {
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("this is new thread.");
        someMethod();
    }

    private void someMethod() {
        //throw new RuntimeException();
    }

}

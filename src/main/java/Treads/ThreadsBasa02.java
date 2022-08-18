package Treads;

public class ThreadsBasa02 {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        resource.setValue(5);

        TestThread testThread = new TestThread();
        testThread.setName("One Thread");
        TestThread testThread2 = new TestThread();
        testThread2.setName("Second Thread");

        testThread.resource = resource;
        testThread2.resource = resource;

        testThread.start();
        testThread2.start();

        testThread.join();
        testThread2.join();

        System.out.println(resource.getValue());

    }
}

class TestThread extends Thread {
    Resource resource;

    @Override
    public void run() {
        resource.changeValue();
    }
}


class Resource {

    private int value;

    public int getValue(){
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public synchronized void changeValue(){
        int value = this.value;
        if(Thread.currentThread().getName().equals("One Thread")){
            Thread.yield();
        }

        value++;
        this.value = value;
    }

}

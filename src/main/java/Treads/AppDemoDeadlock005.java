package Treads;

public class AppDemoDeadlock005 {




    public static void main(String[] args) {


        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;


        MyThread01 myThread01 = new MyThread01(resourceA);
        MyThread02 myThread02 = new MyThread02(resourceB);

        myThread01.start();
        myThread02.start();


    }


}

class MyThread01 extends Thread{
    ResourceA resourceA;

    public MyThread01(ResourceA resourceA){
        this.resourceA = resourceA;
    }

    @Override
    public void run() {
        System.out.println(resourceA.getID());

    }
}

class MyThread02 extends Thread{
    ResourceB resourceB;

    public MyThread02(ResourceB resourceB){
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        System.out.println(resourceB.getID());

    }
}

class ResourceA{
    ResourceB resourceB;

    public synchronized int getID() {
        return resourceB.returnID();
    }

    public synchronized int returnID() {
        return 11;
    }
}

class ResourceB {
    ResourceA resourceA;

    public synchronized int getID() {
        return resourceA.returnID();
    }

    public synchronized int returnID() {
        return 22;
    }
}
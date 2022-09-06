package Patterns.creational;

public class AppDemo004_SingletonV2 {

    public static void main(String[] args) {

        SingletonV2 singleton = SingletonV2.getInstance();
        singleton.doAction();

    }

}

class SingletonV2 {

    private static SingletonV2 instance = new SingletonV2();

    private SingletonV2(){
        //create something
    }

    public static SingletonV2 getInstance(){
        return instance;
    }

    public void doAction(){
        System.out.println("SingletonV2 doAction");
    }

}

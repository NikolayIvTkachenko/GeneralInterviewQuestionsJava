package Patterns.creational;

public class AppDemo004_SingletonV1 {

    public static void main(String[] args) {

        SingletonV1 singleton = SingletonV1.getInstance();
        singleton.doAction();
    }

}
//Lazy create singleton
class SingletonV1 {

    private static SingletonV1 instance;

    private SingletonV1(){
        //create something
    }

    public static SingletonV1 getInstance(){
        if(instance == null){
            instance = new SingletonV1();
        }
        return instance;
    }

    public void doAction(){
        System.out.println("SingletonV1 doAction");
    }

}

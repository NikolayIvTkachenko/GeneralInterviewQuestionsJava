package Generics;

public class Container<T> {
    T value;

    public Container(){}

    public Container(T value){
        this.value = value;
    }

    public void show(){
        System.out.println(value.getClass().getName());
    }
}

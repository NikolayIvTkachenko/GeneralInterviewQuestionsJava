package Generics;

public class ValueContainer<T, V> {

    T obj;
    V obj02;

    public ValueContainer(){}

    public ValueContainer(T obj, V obj02) {
        this.obj = obj;
        this.obj02 = obj02;
    }

    void showType(){
        System.out.println("Show Type ValueContainer fields");
        System.out.println(obj.getClass().getName());
        System.out.println(obj02.getClass().getName());
    }


}

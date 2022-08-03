package Generics;

public class Block<T extends Number> {

    T value;

    public Block(){}

    public Block(T value){
        this.value = value;
    }

    public void show(){
        System.out.println(value.getClass().getName());
    }

    boolean absEqual(Block<T> obj){
        if(Math.abs(value.doubleValue()) == Math.abs(obj.value.doubleValue())){
            return true;
        }
        return false;
    }
}

package Generics;

import java.util.ArrayList;
import java.util.List;


public class AppGenericsMain {

    public static void main(String[] args) {

        int value1 = 9;
        String value2 = "Hello World";

        List values = new ArrayList<>();

        values.add(value1);
        values.add(value2);

        //will error
        //int i = Integer.parseInt(values.get(1).toString());
        //System.out.println("i = " + i);
        //int i1 = (Integer)values.get(1);
        //System.out.println("i1 = " + i1);

//        Container<?> obj = new Container<>();
//        obj.value = "hello";
//        obj.show();

        Container<Integer> objInteger = new Container<>();
        objInteger.value = 9;
        objInteger.show();


        //will work
        Block<Number> objBlockNumber = new Block<>();

        //not work
        //Block<String>objBlockNumber = new Block<>();


        Container c01 = new Container(10);
        Container c02 = new Container(20.2);
        Container c03 = new Container("Hello");

        c01.show();
        c02.show();
        c03.show();

        ValueContainer<String, Integer> valueObj = new ValueContainer<>("Hello", 30);
        valueObj.showType();

        Block block01 = new Block(5.0);
        Block block02 = new Block(-5);

        System.out.println(block01.absEqual(block02));

    }


}

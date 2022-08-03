package Collections.kotlin_java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {

    public static void show(){

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("h");
        list.add("c");
        list.add("b");

        list.add(0, "!");
        System.out.println(list);

        Collections.addAll(list, "f", "g", "h");
        System.out.println(list.get(4));
        list.remove(4);
        System.out.println(list.get(4));
        System.out.println(list.indexOf("h"));
        System.out.println(list.lastIndexOf("h"));


        System.out.println(list.subList(0, 2));
    }

}

package Collections.kotlin_java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionDemo {

    public static void show(){

        Collection<String> collection = new ArrayList<>();

        collection.add("a");
        collection.add("b");
        collection.add("c");

        System.out.println(collection);

        for (var item : collection){
            System.out.println(item);
        }

        Collections.addAll(collection, "d", "f", "r");
        collection.remove("a");
        System.out.println(collection);
        System.out.println(collection.isEmpty());

        Object[] objectArray = collection.toArray();
        String[] stringArray = collection.toArray(new String[3]);

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);
        System.out.println(collection == other);
        System.out.println(collection.equals(other));



    }

}

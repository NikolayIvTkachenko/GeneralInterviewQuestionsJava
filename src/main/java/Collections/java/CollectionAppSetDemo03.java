package Collections.java;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollectionAppSetDemo03 {

    public static void main(String[] args) {

        Set<Integer> sets = new HashSet<>();
        sets.add(100);
        sets.add(5);
        sets.add(9);
        sets.add(3);
        sets.add(4);
        sets.add(7);
        sets.add(3);
        sets.add(1);


        System.out.println(sets);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(9);
        linkedHashSet.add(5);
        linkedHashSet.add(3);
        linkedHashSet.add(7);

        System.out.println(linkedHashSet);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(100);
        treeSet.add(70);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(9);
        treeSet.add(5);
        treeSet.add(3);
        treeSet.add(7);

        System.out.println(treeSet);



    }

}

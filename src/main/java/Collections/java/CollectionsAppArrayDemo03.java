package Collections.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsAppArrayDemo03 {

    public static void main(String[] args) {

        //ArrayList
        System.out.println("ArrayList");
        ArrayList<String> people = new ArrayList<>();

        int[] array = new int[100];

        people.add("Nick");
        people.add("John");
        people.add("Andre");

        people.remove("John");
        people.remove(1);

        if(people.contains("Nick")){
            System.out.println("Nick is in the list");
        }

        if(people.isEmpty()){
            System.out.println("The list is empty!");
        }

        people.clear();

        //LinkedList
        System.out.println("LinkedList");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(0);
        linkedList.remove(Integer.valueOf(3));

        System.out.println("");
        linkedList.clear();

        linkedList.offer(1);
        linkedList.offer(2);
        linkedList.offer(3);

        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());

        linkedList.clear();

        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);

        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());

        //List Sort
        System.out.println("List Sort");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(2);
        integerList.add(5);
        integerList.add(1);
        integerList.add(3);
        integerList.add(3);
        integerList.add(1);

        System.out.println("Unsorted -> " + integerList);

        Collections.sort(integerList);

        System.out.println("Sorted -> " + integerList);


        System.out.println("Binary Search result -> " + Collections.binarySearch(integerList, 4));
        System.out.println("Binary Search result -> " + Collections.binarySearch(integerList, 3));

        System.out.println("Frequency of 3 -> " + Collections.frequency(integerList, 3));

        System.out.println("Max element in the list: " + Collections.max(integerList));
        System.out.println("Min element in the list: " + Collections.min(integerList));

        Collections.shuffle(integerList);
        System.out.println("Shuffled list: " + integerList);

        Collections.swap(integerList, 0, 1);
        System.out.println("First 2 elements swapped: " + integerList);

        Collections.fill(integerList, 3);
        System.out.println("List filled with 3: " + integerList);

    }
}

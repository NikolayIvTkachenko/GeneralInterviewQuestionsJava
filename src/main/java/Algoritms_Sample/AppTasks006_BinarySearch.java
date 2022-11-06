package Algoritms_Sample;

/*

Дано массив чисел необходимо выполнить бинарный поиск
{3, 8, 7, 2, 3, 4, 9, 12, 11, 75, 43, 6, 15, 17, 1, 67, 89,}

*/
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class AppTasks006_BinarySearch {

    public static void main(String[] args) {

        ArrayList<Integer> listValues = new ArrayList<>();
        listValues.add(3);
        listValues.add(8);
        listValues.add(7);
        listValues.add(2);
        listValues.add(3);
        listValues.add(4);
        listValues.add(9);
        listValues.add(12);
        listValues.add(11);
        listValues.add(75);
        listValues.add(43);
        listValues.add(6);
        listValues.add(15);
        listValues.add(17);
        listValues.add(1);
        listValues.add(67);
        listValues.add(89);

        Integer value = 7;

        boolean valueExist = binarySearch(listValues, value);
        System.out.println("value = " + value + " => " +valueExist );

    }

    //before sort list = [3, 8, 7, 2, 3, 4, 9, 12, 11, 75, 43, 6, 15, 17, 1, 67, 89]
    //after sort list = [1, 2, 3, 3, 4, 6, 7, 8, 9, 11, 12, 15, 17, 43, 67, 75, 89]
    private static boolean binarySearch(ArrayList<Integer> list, Integer value){

        System.out.println("before sort list = " + list);
        Collections.sort(list);
        System.out.println("after sort list = " + list);

        int start = 0;
        int end = list.size()-1;
        System.out.println("start algorithm");
        while(start < end) {
            int med = start + (end-start)/2;
            System.out.println("med =" + med);
            System.out.println("start = " + start );
            System.out.println("end = " + end);
            System.out.println("value = " + value);
            System.out.println("list.get(med) = " + list.get(med));
            if (value < list.get(med)) {
                end = med;
            } else if (value > list.get(med)) {
                start = med;
            } else if (value == list.get(med)){
                return true;
            }
        }
        return false;
    }

}

package Algoritms_Sample;

/*
Данн массив, в котором все кроме одного элемента парные
Определить не парный элемент
{4, 3, 9, 1, 5, 11, 5, 4, 9, 3, 1}

Должен определить = 11


*/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AppTasks004_Array_Find_Not_Pair_Value {

    public static void main(String[] args) {

        ArrayList<Integer> listValues = new ArrayList<>();
        listValues.add(4);
        listValues.add(3);
        listValues.add(9);
        listValues.add(1);
        listValues.add(5);
        listValues.add(11);
        listValues.add(5);
        listValues.add(4);
        listValues.add(9);
        listValues.add(3);
        listValues.add(1);
        System.out.println(listValues);

        handleArrayV01(listValues);

        handleArrayWithStreamV02(listValues);

        handleArraySetV02(listValues);

        handleArrayBeforeSortV03(listValues);


        listValues = new ArrayList<>();
        listValues.add(4);
        listValues.add(3);
        listValues.add(9);
        listValues.add(1);
        listValues.add(5);
        listValues.add(7);
        listValues.add(5);
        listValues.add(4);
        listValues.add(9);
        listValues.add(3);
        listValues.add(1);
        System.out.println(listValues);
        handleArrayBeforeSortV03(listValues);
    }

    private static void handleArrayV01(ArrayList<Integer> list){
        System.out.println("handleArrayV01");
        Integer result = 0;
        for(int i = 0; i<list.size(); i++){
            result = result ^ list.get(i);
        }
        System.out.println("result = " + result);
    }

    //Объект BinaryOperator<T> представляет функцию, которая принимает два элемента и выполняет над ними некоторую операцию, возвращая результат.
    //При этом метод reduce сохраняет результат и затем опять же применяет к этому результату и следующему элементу в наборе
    private static void handleArrayWithStreamV02(ArrayList<Integer> list){
        //.reduce((value1, value2) -> value1 + value2);
        System.out.println("handleArrayWithStreamV02");
        Integer result = 0;
        result = list.stream().reduce((value1, value2) -> value1 ^ value2).get();
        System.out.println("result = " + result);
    }

    private static void handleArraySetV02(ArrayList<Integer> list){
        System.out.println("handleArraySetV02");
        Integer result = 0;
        Set<Integer> setValue = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
            if(setValue.contains(list.get(i))){
                setValue.remove(list.get(i));
            } else {
                setValue.add(list.get(i));
            }
        }

        result = setValue.stream().collect(Collectors.toList()).get(0);
        System.out.println("result = " + result);
    }

    private static void handleArrayBeforeSortV03(ArrayList<Integer> list) {
        System.out.println("handleArrayBeforeSortV03");
        System.out.println("list = " + list);
        Integer result = 0;

        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        sortedList.addAll(list.stream().sorted().toList());
        System.out.println("sortedList = " + sortedList);

        for (int i = 0; i < sortedList.size(); i++){
            System.out.println("i = " + i);

            if(i == sortedList.size()-1){
                result = sortedList.get(i);
            } else if (i < sortedList.size()-1){
                if(sortedList.get(i) == sortedList.get(i+1)){
                    i++;
                } else {
                    result = sortedList.get(i);
                }
            }
        }
        System.out.println("result = " + result);
    }


}

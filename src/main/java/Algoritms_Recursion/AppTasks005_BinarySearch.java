package Algoritms_Recursion;

import java.util.ArrayList;

public class AppTasks005_BinarySearch {

    public static void main(String[] args) {

        ArrayList<Long> list01 = new ArrayList<>();
        list01.add(3L);
        list01.add(5L);
        list01.add(6L);
        list01.add(3L);
        list01.add(8L);
        list01.add(9L);
        list01.add(10L);
        list01.add(14L);
        list01.add(16L);
        list01.add(17L);
        list01.add(18L);
        list01.add(19L);
        list01.add(20L);
        list01.add(21L);
        list01.add(22L);
        list01.add(24L);
        list01.add(26L);

        Long searchValue = 26L;
        Integer indexValue = findIndex(searchValue, list01);
        Long valueSearch = list01.get(indexValue);
        System.out.println("Binary Search in Loop");
        System.out.println("indexValue = " + indexValue);
        System.out.println("valueSearch = " + valueSearch);


        indexValue = recursionFindIndex(searchValue, 0, list01.size()-1, list01);
        valueSearch = list01.get(indexValue);
        System.out.println("Binary Search in Recursion");
        System.out.println("indexValue = " + indexValue);
        System.out.println("valueSearch = " + valueSearch);



    }

    //Бинарный поиск в рекурсии
    private static Integer recursionFindIndex(Long searchValue,
                                              Integer lowerBound,
                                              Integer upperBound,
                                              ArrayList<Long> list){
        Integer index;
        index = (lowerBound + upperBound)/2;
        if(list.get(index) == searchValue) return index;
        else if (lowerBound > upperBound) return list.size();
        else {
            if(list.get(index) < searchValue) {
                return recursionFindIndex(searchValue, index+1, upperBound, list);
            } else {
                return recursionFindIndex(searchValue, lowerBound, index-1, list);
            }
        }
    }


    //Стандарный бинарный поиск в цикле
    private static Integer findIndex (Long searchValue, ArrayList<Long> list){
        Integer lowerBond = 0;
        Integer upperBound = list.size()-1;
        Integer index;
        while(true){

            index = (lowerBond + upperBound) / 2;
            if(list.get(index) == searchValue){
                return index;
            } else if (lowerBond > upperBound){
                return list.size();
                //Возвращаем в качестве элемента размер массив, при обращению к массиву
                //возникнет ошибка -> за пределами массива
            } else {
                if (list.get(index) < searchValue){
                    lowerBond = index + 1;
                } else {
                    upperBound = index - 1;
                }
            }

        }
    }

}

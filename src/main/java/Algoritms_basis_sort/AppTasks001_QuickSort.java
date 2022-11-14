package Algoritms_basis_sort;

public class AppTasks001_QuickSort {

    public static void main(String[] args) {

        int[] array01 = new int[] {53, 32, 67, 76, 24, 12, 89, 99, 47, 78, 97, 46, 22, 41};
        System.out.println(arrayToString(array01));

        quickSort(array01, 0, array01.length-1);
        System.out.println(arrayToString(array01));

    }




    private static void quickSort(int[] arr, int from, int to){
        if(from < to) {

            int divideIndex = partition(arr, from, to);
            //printSortStep(arr, from, to, divideIndex);

            quickSort(arr, from, divideIndex - 1);
            quickSort(arr, divideIndex, to);


        }
    }


    private static int partition(int[] arr, int from, int to){
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from]; //случайную точку, пусть начало списка
        //лучше серилина
        while (leftIndex <= rightIndex) {

            while(arr[leftIndex] < pivot){
                leftIndex++;
            }

            while(arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if(leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }


    private static void swap(int[] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0; i < array.length; i++){
            if(i > 0){
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}

package Algoritms_basis;

import java.util.Arrays;

public class Sort_Selection {

    public static void main(String[] args) {
        int[] data = {5, 3, 77, 89, 908, 45, 67, 34, 2};

        sortSelection(data);
        System.out.println("Selection Sort");
        Arrays.stream(data).forEach(System.out::println);

    }

    private static void sortSelection(int[] data){
        int n = data.length;
        for(int i = 0; i < n - 1; i++){
            int min_index = i;
            for(int j = i + 1; j < n; j++){
                if(data[min_index] > data[j]){
                    min_index = j;
                }
            }
            swap(i, min_index, data);

        }
    }


    private static void swap(int i, int min_index, int[] data){
        int temp = data[i];
        data[i] = data[min_index];
        data[min_index] = temp;
    }

}

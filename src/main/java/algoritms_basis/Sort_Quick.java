package algoritms_basis;

import java.util.Arrays;

public class Sort_Quick {

    public static void main(String[] args) {
        int[] data = {5, 3, 77, 89, 908, 45, 67, 34, 2};

        sortQuick(data, 0, data.length-1);

        System.out.println("Quick Sort");
        Arrays.stream(data).forEach(System.out::println);

        System.out.println("Binary search");
        System.out.println(data[Algoritm_BinarySearch.searchBinary(data, 45)]); // return index
        System.out.println(Algoritm_BinarySearch.searchBinaryValue(data, 34)); // return value


    }

    private static void sortQuick(int[] data, int l, int r){
        if(l >= r) return;
        int pi = partition(data, l, r);

        sortQuick(data, l, pi - 1);
        sortQuick(data, pi + 1, r);

    }

    private static int partition(int[] data, int l, int r) {
        int pivot = data[r];
        int ptr = l - 1;

        for(int i = l; i < r; i++){
            if(data[i] < pivot) {
                ptr++;
                swap(ptr, i, data);
            }
        }
        swap(ptr + 1, r, data);
        return ptr + 1;
    }

    private static void swap(int ptr, int i, int[] data){
        int temp = data[ptr];
        data[ptr] = data[i];
        data[i] = temp;
    }

}

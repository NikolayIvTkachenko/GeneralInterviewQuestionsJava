package Algoritms_basis_sort;

public class AppTasks004_InsertionSort {

    public static void main(String[] args) {

        int[] array01 = new int[] {32, 12, 45, 67, 23, 22, 18, 9, 5, 57, 49, 51, 70, 72, 78, 90, 82, 84, 71};

        System.out.println("SHOW ARRAY");
        System.out.println(arrayToString(array01));
        System.out.println("");
        System.out.println("SHOW SORT ARRAY");
        System.out.println(arrayToString(insertionSort(array01)));
        
    }

    private static int[] insertionSort(int[] array){
        for(int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while(j > 0 && array[j-1] > current) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = current;
        }
        return array;
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

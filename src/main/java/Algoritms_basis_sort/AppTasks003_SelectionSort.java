package Algoritms_basis_sort;

public class AppTasks003_SelectionSort {

    public static void main(String[] args) {
        int[] array01 = new int[] {32, 12, 45, 67, 23, 22, 18, 9, 5, 57, 49, 51, 70, 72, 78, 90, 82, 84, 71};

        System.out.println(arrayToString(array01));
        System.out.println("min value index: " + min(array01, 0));

        System.out.println("");
        System.out.println("SELECTION SORT");
        System.out.println(arrayToString(selectionSort(array01)));

    }


    private static int[] selectionSort(int[] array){
        for(int step = 0; step < array.length; step++) {
            int index = min(array, step);

            int tmp = array[step];
            array[step] = array[index];
            array[index] = tmp;
        }

        return array;
    }


    private static int min(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];
        for(int i = start + 1; i < array.length; i++) {
            if(array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
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

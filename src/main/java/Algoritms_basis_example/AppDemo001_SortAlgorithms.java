package Algoritms_basis_example;

import javax.sound.midi.Soundbank;

public class AppDemo001_SortAlgorithms {

    public static void main(String[] args) {

        int[] array01 = {
                10, 3, 1, 2, 10, 5, 45, 2, 7, 8,
                32, 12, 56, 99, 90, 43, 24, 28, 37, 18,
                17, 11, 70, 90, 58, 96, 54, 23, 16, 97,
                88, 84, 76, 87, 59, 69, 91, 44, 55, 22
        };
        showInLineArray(array01);
        System.out.println();

        System.out.println("= 1. Use Bubble sort Algorithm");
        int[] bubbleSortedArray = AlgorithmSorts.getInstance().useBubbleSort(array01);
        showInLineArray(bubbleSortedArray);
        System.out.println();
        System.out.println("= 1. End block");

        System.out.println();
        System.out.println("= 2. Use Selection sort Algorithm");
        int[] selectionSortedArray = AlgorithmSorts.getInstance().useSelectionSort(array01);
        showInLineArray(selectionSortedArray);
        System.out.println();
        System.out.println("= 2. End block");

        System.out.println();
        System.out.println("= 3. Use Insertion sort Algorithm");
        int[] insertionSortedArray = AlgorithmSorts.getInstance().useInsertionSort(array01);
        showInLineArray(insertionSortedArray);
        System.out.println();
        System.out.println("= 3. End block");

        System.out.println();
        System.out.println("= 4. Use Shell sort Algorithm");
        int[] shellSortedArray = AlgorithmSorts.getInstance().useShellSort(array01);
        showInLineArray(shellSortedArray);
        System.out.println();
        System.out.println("= 4. End block");

        System.out.println();
        System.out.println("= 5. Use Shuttle sort Algorithm");
        int[] shuttleSortedArray = AlgorithmSorts.getInstance().useShuttleSort(array01);
        showInLineArray(shuttleSortedArray);
        System.out.println();
        System.out.println("= 5. End block");

        System.out.println();
        System.out.println("= 6. Use Merge sort Algorithm");
        int[] mergeSortedArray = AlgorithmSorts.getInstance().useMergeSort(array01, 0 , array01.length-1);
        showInLineArray(mergeSortedArray);
        System.out.println();
        System.out.println("= 6. End block");







    }
    private static void showInLineArray(int[] array01){
        for(int i = 0; i < array01.length; i++){
            if (i == 0){
                System.out.print(array01[i]);
            }else if(i == array01.length - 1){
                System.out.print(", " + array01[i]);
            }else{
                System.out.print(", " + array01[i]);
            }
        }
    }

}

class AlgorithmSorts{

    private static AlgorithmSorts instance = new AlgorithmSorts();
    private AlgorithmSorts(){}

    public static AlgorithmSorts getInstance(){
        return instance;
    }

    public int[] useBubbleSort(int[] array){
        System.out.println("== Start Bubble Sort Algorithm ==");
        Long startTime = System.currentTimeMillis();

        boolean needIteration = true;
        while(needIteration) {
            needIteration = false;
            for(int i = 1; i < array.length; i++){
                if(array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
        }

        Long endTime = System.currentTimeMillis();
        showTimeValues(startTime, endTime);
        return array;
    }

    public int[] useSelectionSort(int[] array){
        System.out.println("== Start Selection Sort Algorithm ==");
        Long startTime = System.currentTimeMillis();

        for (int left = 0; left < array.length; left++){
            int minInd = left;
            for(int i = left; i < array.length; i++){
                if(array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }


        Long endTime = System.currentTimeMillis();
        showTimeValues(startTime, endTime);
        return array;
    }

    public int[] useInsertionSort(int[] array){
        System.out.println("== Start Insertion Sort Algorithm ==");
        Long startTime = System.currentTimeMillis();

        for(int left = 0; left < array.length; left++){
            int value = array[left];
            int i = left - 1;
            for(; i>=0; i--){
                if (value < array[i]){
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }

        Long endTime = System.currentTimeMillis();
        showTimeValues(startTime, endTime);
        return array;
    }

    public int[] useShuttleSort(int[] array){
        System.out.println("== Start Insertion Sort Algorithm ==");
        Long startTime = System.currentTimeMillis();

        for(int i = 1; i < array.length; i++){
            if(array[i] < array[i-1]){
                swap(array, i, i - 1);
                for(int z = i - 1; (z - 1) >= 0; z--){
                    if(array[z] < array[z - 1]){
                        swap(array, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }

        Long endTime = System.currentTimeMillis();
        showTimeValues(startTime, endTime);
        return array;
    }

    public int[] useShellSort(int[] array){
        System.out.println("== Start Insertion Sort Algorithm ==");
        Long startTime = System.currentTimeMillis();

        int gap = array.length / 2;
        while(gap >= 1) {
            for(int right = 0; right < array.length; right++) {
                for(int c = right - gap; c >= 0; c -= gap) {
                    if(array[c] > array[c + gap]) {
                        swap(array, c, c + gap);
                    }
                }
            }
            gap = gap / 2;
        }

        Long endTime = System.currentTimeMillis();
        showTimeValues(startTime, endTime);
        return array;
    }

    public int[] useMergeSort(int[] array, int left, int right){
        System.out.println("== Start Insertion Sort Algorithm ==");
        Long startTime = System.currentTimeMillis();

        array = mergeSort(array, left, right );

        Long endTime = System.currentTimeMillis();
        showTimeValues(startTime, endTime);
        return array;
    }

    private int[] mergeSort(int[] array, int left, int right){
        int delimiter = left + ((right - left) / 2) + 1;
        if(delimiter > 0 && right > (left + 1)){
            mergeSort(array, left, delimiter - 1);
            mergeSort(array, delimiter, right);
        }

        int[] buffer = new int [right - left + 1];
        int cursor = left;

        for(int i = 0; i < buffer.length; i++) {
            if(delimiter > right || array[cursor] > array[delimiter]){
                buffer[i] = array[cursor];
                cursor++;
            } else {
                buffer[i] = array[delimiter];
                delimiter++;
            }
        }
        return array;
    }


    public int[] useCountingSort(int[] array, int maxValue){
        System.out.println("== Start Insertion Sort Algorithm ==");
        Long startTime = System.currentTimeMillis();

        int numCounts[] = new int[maxValue + 1];
        for(int num : array){
            numCounts[num]++;
        }

        int[] sortedArray = new int[array.length];
        int currentSortedIndex = 0;
        for(int n = 0; n < numCounts.length; n++){
            int count = numCounts[n];
            for(int k = 0; k < count; k++){
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }

        Long endTime = System.currentTimeMillis();
        showTimeValues(startTime, endTime);
        return sortedArray;
    }

    public int[] useQuickSort(int[] array, int leftBorder, int rightBorder){
        System.out.println("== Start Insertion Sort Algorithm ==");
        Long startTime = System.currentTimeMillis();

        array = quickSort(array, leftBorder, rightBorder);

        Long endTime = System.currentTimeMillis();
        showTimeValues(startTime, endTime);
        return array;
    }

    private int[] quickSort(int[] array, int leftBorder, int rightBorder){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {

            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] < pivot) {
                rightMarker--;
            }

            if(leftMarker <= rightMarker){

                if(leftMarker < rightMarker){
                    int tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }

                leftMarker++;
                rightMarker--;
            }
        }while (leftMarker <= rightMarker);

        if(leftMarker < rightBorder){
            useQuickSort(array, leftMarker, rightBorder);
        }

        if(leftBorder < rightMarker){
            useQuickSort(array, leftBorder, rightMarker);
        }
        return array;
    }

    private void showTimeValues(Long start, Long end){
        System.out.println("Start Time (ms) = " + start);
        System.out.println("End Time (ms) = " + end);
        Long delta = end - start;
        System.out.println("Delta Time (ms) = " + delta);
        System.out.println();
    }
    private void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}




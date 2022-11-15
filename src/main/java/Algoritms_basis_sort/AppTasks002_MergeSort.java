package Algoritms_basis_sort;

public class AppTasks002_MergeSort {
    public static void main(String[] args) {
        int[] arra01 = new int[] {32, 12, 45, 67, 23, 22, 18, 9, 5, 57, 49, 51, 70, 72, 78, 90, 82, 84, 71};
        System.out.println(arrayToString(arra01));

        System.out.println(arrayToString(mergeSort(arra01)));

    }

    private static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;

        while (size < array.length){
            for(int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

            System.out.println(arrayToString(currentSrc));
        }

        return currentSrc;
    }


    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size){
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for(int i = destStart; i < destStart + iterationCount; i++){
            if(index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])){
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }

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

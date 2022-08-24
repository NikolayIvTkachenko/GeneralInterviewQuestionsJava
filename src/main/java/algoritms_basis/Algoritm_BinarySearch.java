package algoritms_basis;

public class Algoritm_BinarySearch {

    //return index
    public static int searchBinary(int[] list, int target){

        int left = 0;
        int right = list.length - 1;

        while (left <= right){
            int middle = (left + right) / 2;
            if(target < list[middle]){
                right = middle - 1;
            } else if (target > list[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //return index
    public static int searchBinaryValue(int[] list, int target){

        int left = 0;
        int right = list.length - 1;

        while (left <= right){
            int middle = (left + right) / 2;
            if(target < list[middle]){
                right = middle - 1;
            } else if (target > list[middle]) {
                left = middle + 1;
            } else {
                return list[middle];
            }
        }
        return -1;
    }
}

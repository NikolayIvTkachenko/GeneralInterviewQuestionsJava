package algoritms_basis;

import java.util.Arrays;

public class Sort_Bubble {


    public static void main(String[] args) {

        int[] data = {5, 3, 77, 89, 908, 45, 67, 34, 2};
        sortBubble(data);

        System.out.println("Bubble Sort");
        Arrays.stream(data).forEach(System.out::println);

    }

    private static void sortBubble(int[] data) {
        int n = data.length;

        for(int i = 0; i < n - 1; i++) {
            for(int j = 1; j < n - i; j++){
                if(data[j] < data[j - 1]){
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }

    }



}

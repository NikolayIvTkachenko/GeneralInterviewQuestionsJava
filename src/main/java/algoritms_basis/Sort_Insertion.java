package algoritms_basis;

import java.util.Arrays;

public class Sort_Insertion {

    public static void main(String[] args) {

        int[] data = {5, 3, 77, 89, 908, 45, 67, 34, 2};
        sortInsertion(data);

        System.out.println("Insertion Sort");
        Arrays.stream(data).forEach(System.out::println);

    }

    private static void sortInsertion(int[] data) {
        int n = data.length;

        for(int i = 1; i < n; i++) {
            int curr = data[i];
            int j = i - 1;

            while(j >= 0 && data[j] > curr) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = curr;
        }
    }

}

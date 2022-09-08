package Algoritms_basis;


import java.util.Arrays;

public class Sort_Merge {

    public static void main(String[] args) {

        int[] data = {5, 3, 77, 89, 908, 45, 67, 34, 2};
        sortMerge(data);

        System.out.println("Merge Sort");
        Arrays.stream(data).forEach(System.out::println);

    }


    private static void sortMerge(int[] data){
        int n = data.length;
        if(n == 1)return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for(int i = 0; i < mid; i++){
            l[i] = data[i];
        }

        for(int i = mid; i < n; i++){
            r[i - mid] = data[i];
        }

        sortMerge(l);
        sortMerge(r);
        merge(data, l, r);

    }

    private static void merge(int[] data, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;

        int i = 0;
        int j = 0;
        int idx = 0;

        while(i < left && j < right) {
            if(l[i] < r[j]){
                data[idx] = l[i];
                i++;
                idx++;
            } else {
                data[idx] = r[j];
                j++;
                idx++;
            }
        }

        for(int ll = i; ll < left; ll++){
            data[idx++] = l[ll];
        }

        for(int rr = j; rr < right; rr++) {
            data[idx++] = r[rr];
        }

    }

}

package algoritms_basis;

public class Algoritm_Summ {

    public static void main(String[] args) {

        System.out.println(summ(15));


    }

    public static int summ(int n) {
        if(n == 1) return 1;
        return n + summ(n-1);
    }

}

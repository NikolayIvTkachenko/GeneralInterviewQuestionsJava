package Algoritms_Recursion;

public class AppTasks002_Factorial {

    public static void main(String[] args) {

        int value00 = 5;
        int result00 = factorial(value00);
        System.out.println("result00 = " + result00);

        int value01 = 6;
        int result01 = factorial(value01);
        System.out.println("result01 = " + result01);

    }

    static int factorial(int n){
        if(n==0)
            return 1;
        else
            return (n * factorial(n-1) );
    }

}

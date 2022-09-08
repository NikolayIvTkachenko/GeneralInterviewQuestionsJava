package Algoritms_basis;

import java.util.Arrays;

public class Algoritm_fibonachi_fib {

    private static long[] fibonacciCache;

    public static void main(String[] args) {

        System.out.println("== V0 ===");
        System.out.println(fib(3));

        System.out.println("== V1 ===");
        int n = 50;
        fibonacciCache = new long[n + 1];
        for(int i = 0; i <= n; i++){
            System.out.println(fibonacci(i) + " ");
        }

        System.out.println("== V3 ===");
        System.out.println("fibonacciCache: ");
        Arrays.stream(fibonacciCache).forEach(System.out::println);



    }

    public static int fib (int n){
        if(n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    private static long fibonacci(int n){
        if(n <= 1) {
            return n;
        }

        if(fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }

        long nthFibonacciNumber = (fibonacci(n - 1) + fibonacci(n - 2));
        fibonacciCache[n] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }


}

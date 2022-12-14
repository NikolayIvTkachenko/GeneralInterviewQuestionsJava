package Algoritms_Recursion;

public class AppTasks001_N_Triangle_Value {

    //Рекурсия обычно применяется ради концептуального упрощения задачи, а не
    //оттого, что она изначально более эффективна.
    public static void main(String[] args) {
        int testValue01 = 3;
        int testValue02 = 6;

        int resultValue01 = trinagleLoop(testValue01);
        int resultValue02 = trinagleLoop(testValue02);
        System.out.println("Loop: ");
        System.out.println("resultValue01 = " + resultValue01);
        System.out.println("resultValue02 = " + resultValue02);


        System.out.println("Recursion: ");
        testValue01 = 3;
        testValue02 = 6;
        resultValue01 = triangleRecursion(testValue01);
        resultValue02 = triangleRecursion(testValue02);

        System.out.println("resultValue01 = " + resultValue01);
        System.out.println("resultValue02 = " + resultValue02);

        System.out.println("Recursion Error: ");
        testValue01 = 3;
        resultValue01 = triangleRecursionError(testValue01);
        System.out.println("resultValue01 = " + resultValue01);
    }

    //Loop
    private static int trinagleLoop(int n){
        int total = 0;

        while(n > 0) {
            total = total + n;
            --n;
        }

        return total;
    }



    //Recursion
    static int triangleRecursion(int n){
        if(n==1){
            return 1;
        }else {
            return (n + triangleRecursion(n - 1));
        }
    }

    //Recursion Error
    //loopValues = 13629
    //Exception in thread "main" java.lang.StackOverflowError
    static int loopValues = 0;
    static int triangleRecursionError(int n){
        loopValues++;
        System.out.println("loopValues = " + loopValues);
        return (n + triangleRecursionError(n - 1));
    }

}

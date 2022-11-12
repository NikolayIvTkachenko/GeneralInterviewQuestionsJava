package Algoritms_Recursion;

public class AppTasks001_N_Triangle_Value {

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

}

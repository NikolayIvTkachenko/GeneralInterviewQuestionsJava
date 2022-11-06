package Algoritms_Sample;

public class AppTasks002_BitsOperation {

    public static void main(String[] args) {

        //testBitsOperations();
        //testBitsOperationsV2();


        //AND
        //testBitsOperationsV3();

        //OR
        //testBitsOperationsV4();

        //XOR
        //testBitsOperationsV5();

        //MOVE LEFT
        //testBitsOperationsV6();

        //MOVE RIGHT
        //testBitsOperationsV7();

        //другие числа не кратные двум
        //MOVE LEFT
        //testBitsOperationsV8();

        //MOVE RIGHT
        //testBitsOperationsV9();


        //Custom methods
        testCustomCalculationV1();



    }


    private static void testCustomCalculationV1(){
        int a = 5;
        int b = 1;

        System.out.println("a (dex) = " + a);
        System.out.println("a (bin) = " + Integer.toBinaryString(a));
        System.out.println("b (dex) = " + b);
        System.out.println("b (bin) = " + Integer.toBinaryString(b));

        int c = 5 << 1;
        System.out.println("Результат (dex): 5 << 1 = " + c);
        System.out.println("Результат (bin): 5 << 1 = " + Integer.toBinaryString(c));
        c = 5 << 2;
        System.out.println("Результат (dex): 5 << 2 = " + c);
        System.out.println("Результат (bin): 5 << 1 = " + Integer.toBinaryString(c));

        int d = 5 >> 1;
        System.out.println("Результат (dex): 5 >> 1 = " + d);
        System.out.println("Результат (bin): 5 >> 1 = " + Integer.toBinaryString(d));
        d = 5 >> 2;
        System.out.println("Результат (dex): 5 >> 2 = " + d);
        System.out.println("Результат (bin): 5 >> 1 = " + Integer.toBinaryString(d));

        a = 5; //101
        b = 6; //110
        //XOR
        //101
        //110
        //----
        //011 -> 11 > 3 (dec)

        System.out.println("XOR");
        System.out.println("a (dex) = " + a);
        System.out.println("a (bin) = " + Integer.toBinaryString(a));
        System.out.println("b (dex) = " + b);
        System.out.println("b (bin) = " + Integer.toBinaryString(b));
        d = a ^ b;
        System.out.println("Результат (dex): a ^ b = " + d);
        System.out.println("Результат (bin): a ^ b = " + Integer.toBinaryString(d));

    }


    //MOVE LEFT
    private static void testBitsOperationsV8() {
        int a = 35;
        int b = 1;
        for (int i = 0; i < 7; i++) {
            System.out.println("Умножим: " + a + " на 2");
            int c = a << b;
            System.out.println("Представление числа: " + a + " в двоичной системе исчисления: " + Integer.toBinaryString(a));
            System.out.println("Представление числа: " + c + " в двоичной системе исчисления: " + Integer.toBinaryString(c));
            System.out.println("Результат: " + c);
            a = c;
        }

    }


    //MOVE RIGHT
    private static void testBitsOperationsV9() {
        int a = 35;
        int b = 1;
        for (int i = 0; i < 7; i++) {
            System.out.println("Поделим: " + a + " на 2");
            int c = a >> b;
            System.out.println("Представление числа: " + a + " в двоичной системе исчисления: " + Integer.toBinaryString(a));
            System.out.println("Представление числа: " + c + " в двоичной системе исчисления: " + Integer.toBinaryString(c));
            System.out.println("Результат: " + c);
            a = c;
        }

    }

    //MOVE LEFT
    private static void testBitsOperationsV6() {
        int a = 1;
        int b = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println("Умножим: " + a + " на 2");
            int c = a << b;
            System.out.println("Представление числа: " + a + " в двоичной системе исчисления: " + Integer.toBinaryString(a));
            System.out.println("Представление числа: " + c + " в двоичной системе исчисления: " + Integer.toBinaryString(c));
            System.out.println("Результат: " + c);
            a = c;
        }
    }

    //MOVE RIGHT
    private static void testBitsOperationsV7() {
        int a = 1024;
        int b = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println("Поделим: " + a + " на 2");
            int c = a >> b;
            System.out.println("Представление числа: " + a + " в двоичной системе исчисления: " + Integer.toBinaryString(a));
            System.out.println("Представление числа: " + c + " в двоичной системе исчисления: " + Integer.toBinaryString(c));
            System.out.println("Результат: " + c);
            a = c;
        }
    }

    //XOR
    private static void testBitsOperationsV5() {

        System.out.println("Пример:");
        int a = 7;
        int b = 5;
        int c = a ^ b;
        System.out.println(b);
        System.out.println("Представление числа: " + a + " в двоичной системе исчисления: " + Integer.toBinaryString(a));
        System.out.println("Представление числа: " + b + " в двоичной системе исчисления: " + Integer.toBinaryString(b));
        System.out.println("Представление числа: " + c + " в двоичной системе исчисления: " + Integer.toBinaryString(c));

    }

    //OR
    private static void testBitsOperationsV4() {
        System.out.println("Пример:");
        int a = 7;
        int b = 5;
        int c = a | b;
        System.out.println(b);
        System.out.println("Представление числа: " + a + " в двоичной системе исчисления: " + Integer.toBinaryString(a));
        System.out.println("Представление числа: " + b + " в двоичной системе исчисления: " + Integer.toBinaryString(b));
        System.out.println("Представление числа: " + c + " в двоичной системе исчисления: " + Integer.toBinaryString(c));
    }

    //AND
    private static void testBitsOperationsV3() {
        int a = 7;
        int b = 5;
        int c = a & b;
        System.out.println(b);
        System.out.println("Представление числа: " + a + " в двоичной системе исчисления: " + Integer.toBinaryString(a));
        System.out.println("Представление числа: " + b + " в двоичной системе исчисления: " + Integer.toBinaryString(b));
        System.out.println("Представление числа: " + c + " в двоичной системе исчисления: " + Integer.toBinaryString(c));
    }


    private static void testBitsOperations() {
        System.out.println("Пример работы с типом byte");
        byte a = 47;
        byte b = (byte) ~a;
        System.out.println(b);

        System.out.println("Пример работы с типом short");
        short c = 350;
        short d = (short) ~c;
        System.out.println(d);

        System.out.println("Пример работы с типом int");
        int e = 555555555;
        int f = ~e;
        System.out.println(f);

        System.out.println("Пример работы с типом long");
        long g = 111112222233333L;
        long h = ~g;
        System.out.println(h);
    }

    private static void testBitsOperationsV2() {
        System.out.println("Пример работы с типом byte");
        byte a = 47;
        byte b = (byte) ~a;
        System.out.println(b);
        System.out.println("Представление числа: " + a + " в двоичной системе исчисления: " + Integer.toBinaryString(a));
        System.out.println("Представление числа:" + b + " в двоичной системе исчисления: " + Integer.toBinaryString(b) + "\n");

        System.out.println("Пример работы с типом short");
        short c = 350;
        short d = (short) ~c;
        System.out.println(d);
        System.out.println("Представление числа: " + c + " в двоичной системе исчисления: " + Integer.toBinaryString(c));
        System.out.println("Представление числа:" + d + " в двоичной системе исчисления: " + Integer.toBinaryString(d) + "\n");

        System.out.println("Пример работы с типом int");
        int e = 555555555;
        int f = ~e;
        System.out.println(f);
        System.out.println("Представление числа: " + e + " в двоичной системе исчисления: " + Integer.toBinaryString(e));
        System.out.println("Представление числа:" + f + " в двоичной системе исчисления: " + Integer.toBinaryString(f) + "\n");

        System.out.println("Пример работы с типом long");
        long g = 111112222233333L;
        long h = ~g;
        System.out.println(h);
        System.out.println("Представление числа: " + g + " в двоичной системе исчисления: " + Long.toBinaryString(g));
        System.out.println("Представление числа:" + h + " в двоичной системе исчисления: " + Long.toBinaryString(h) + "\n");

    }


}

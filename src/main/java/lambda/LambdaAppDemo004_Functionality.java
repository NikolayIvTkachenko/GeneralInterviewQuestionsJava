package lambda;

import java.util.Scanner;
import java.util.function.*;

public class LambdaAppDemo004_Functionality {

    public static void main(String[] args) {

        Predicate<Integer> isZero = value -> value == 0;
        System.out.println(isZero.test(5));
        System.out.println(isZero.test(0));

        Consumer<String> printer = message -> System.out.println(message);
        printer.accept("Test Consumer !!!");

        Function<Integer, Double> converter = value -> Double.valueOf(value);
        System.out.println(converter.apply(1));

        UnaryOperator<Double> sqrt = value -> Math.sqrt(value);
        System.out.println(sqrt.apply(5.0));

        BinaryOperator<Double> pow = (v1, v2) -> Math.pow(v1, v2);
        System.out.println(pow.apply(3.0,2.0));



        Supplier<String> text = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter text: ");
            return scanner.nextLine();
        };
        System.out.println(text.get());




    }


}

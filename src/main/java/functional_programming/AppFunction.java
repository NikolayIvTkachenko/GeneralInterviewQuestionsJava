package functional_programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AppFunction {

    public static void main(String[] args) {

        //Function takes 1 argument and produces 1 result
        int increment = incrementByOne(0);
        System.out.println(increment);

        int incrementV2 = incrementByOneFunction.apply(1);
        System.out.println(incrementV2);

        int multiply = multipleBy10.apply(incrementV2);
        System.out.println(multiply);

        int result01 = addByOneAndThenMultiplayBy10.apply(1);
        System.out.println(result01);


        //BiFunction takes 2 argumets and produces 1 result
        System.out.println("incrementByOneAndMultiplybiFunction");
        System.out.println(incrementByOneAndMultiplybiFunction.apply(1,2));
        System.out.println("incrementByOneAndMultiply");
        System.out.println(incrementByOneAndMultiply(1, 2));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number+1;

    static Function<Integer, Integer> multipleBy10 = number -> number * 10;

    static Function<Integer, Integer> addByOneAndThenMultiplayBy10 = incrementByOneFunction.andThen(multipleBy10);

    static int incrementByOne(int number){
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplybiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }

}

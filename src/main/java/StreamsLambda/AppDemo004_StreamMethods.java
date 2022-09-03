package StreamsLambda;

import java.util.stream.Stream;

public class AppDemo004_StreamMethods {

    public static void main(String[] args) {
        System.out.println("= 011 ===");
        Stream<Integer> mixedNumbers = Stream.of(-2, -1, 0, 1, 2);
        System.out.println(mixedNumbers.allMatch(number -> number > 0));

        System.out.println("= 012 ===");
        Stream<Integer> positiveNumbers = Stream.of(1, 2);
        System.out.println(positiveNumbers.allMatch(number -> number > 0));

        System.out.println("= 013 ===");
        Stream<Integer> negativeNumbers = Stream.of(-2, -1);
        System.out.println(negativeNumbers.allMatch(number -> number > 0));

        System.out.println("= 021 ===");
        Stream<Integer> mixedNumbers2 = Stream.of(-2, -1, 0, 1, 2);
        System.out.println(mixedNumbers2.noneMatch(number -> number > 0));

        System.out.println("= 022 ===");
        Stream<Integer> positiveNumbers2 = Stream.of(1, 2);
        System.out.println(positiveNumbers2.noneMatch(number -> number > 0));

        System.out.println("= 023 ===");
        Stream<Integer> negativeNumbers2 = Stream.of(-2, -1);
        System.out.println(!negativeNumbers2.anyMatch(number -> number > 0));

        System.out.println("= 030 ===");
        Stream<Integer> mixedNumbers3 = Stream.of(-2, -1, 0, 1, 2);
        System.out.println(mixedNumbers3.count());



    }

}

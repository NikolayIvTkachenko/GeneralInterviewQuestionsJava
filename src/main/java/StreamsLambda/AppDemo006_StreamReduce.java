package StreamsLambda;

import java.util.Optional;
import java.util.stream.Stream;

public class AppDemo006_StreamReduce {

    public static void main(String[] args) {

        System.out.println("== reduce ===");
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.reduce((value1, value2) -> value1 + value2);
        System.out.println(result.get());

        System.out.println("== reduce 10 ===");
        Stream<Integer> numbers02 = Stream.of(1, 2, 3, 4, 5);
        int result02 = numbers02.reduce(10, (value1, value2) -> value1 + value2);
        System.out.println(result02);

        System.out.println("== reduce 22 ===");
        Stream<Integer> numbers03 = Stream.of(1, 2, 3, 4, 5);
        int result03 = numbers03.reduce(22, (value1, value2) -> value1 + value2);
        System.out.println(result03);

        System.out.println("== reduce condition ===");
        Stream<Integer> numbers04 = Stream.of(1, 2, 3, 4, 5);
        int result04 = numbers04.reduce(0, (value1, value2) -> {
            if (value2 < 5) {
                return value1 + value2;
            } else {
                return value1;
            }
        }, (value1, value2) -> value1 + value2);

        System.out.println(result04);

    }

}

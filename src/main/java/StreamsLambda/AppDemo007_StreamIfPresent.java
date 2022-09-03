package StreamsLambda;

import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppDemo007_StreamIfPresent {

    public static void main(String[] args) {

        System.out.println("= 001 ===");
        Stream<Integer> numbers = Stream.of();
        Optional<Integer> result = numbers.min(Integer::compare);
        result.ifPresent(System.out::println);


        System.out.println("= 002 ===");
        Stream<Integer> numbers2 = Stream.of();
        Optional<Integer> result2 = numbers2.min(Integer::compare);
        System.out.println(result2.orElse(0));


        System.out.println("= 003 ===");
        Stream<Integer> numbers3 = Stream.of();
        Optional<Integer> result3 = numbers3.min(Integer::compare);
        result3.ifPresentOrElse(System.out::println, () -> System.out.println("Stream element not found"));

        System.out.println("= 004 ===");
        Stream<String> values = Stream.of("Value 1", "Value 2", "Value 3", "Value 4", "Value 5");
        values.collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);



    }

}

package StreamsLambda;

import java.util.ArrayList;
import java.util.stream.Stream;

public class AppDemo009_Stream {

    public static void main(String[] args) {

        System.out.println("= Test 01 ===");
        Stream<String> values = Stream.of("Value 1", "Value 2", "Value 3", "Value 4", "Value 5");
        values.collect(ArrayList::new, ArrayList::add, ArrayList::addAll).forEach(System.out::println);

    }

}

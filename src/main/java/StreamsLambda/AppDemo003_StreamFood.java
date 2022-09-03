package StreamsLambda;

import java.util.stream.Stream;

public class AppDemo003_StreamFood {

    public static void main(String[] args) {

        Stream<Food> foodStream = Stream.of(new Food("Pizza", 90), new Food("Pay", 60));

        foodStream.flatMap(food -> Stream.of(
            String.format("Food: %s, price $%d", food.getTitle(), food.getPrice()),
            String.format("(HAPPY HOURS DISCOUNT - 50%%)%n Food: %s, price: $%d)", food.getTitle(), food.getPrice() / 2))
        ).forEach(System.out::println);

    }

}

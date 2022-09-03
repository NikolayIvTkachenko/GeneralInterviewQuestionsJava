package StreamsLambda;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppDemo008_StreamOrder {

    public static void main(String[] args) {

        System.out.println("Orders");
        Stream<Order> orders = Stream.of(new Order(0, "Context 1"), new Order(1, "Context 2"));
        orders.collect(Collectors.toMap(Order::getId, Order::getContext))
                .forEach((key, value) -> System.out.printf("Key: %d, value: %s %n", key, value));


    }


}

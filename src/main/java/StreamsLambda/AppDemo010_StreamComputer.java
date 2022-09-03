package StreamsLambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppDemo010_StreamComputer {

    public static void main(String[] args) {

        Stream<Computer> computerStream = Stream.of(new Computer("Desktop", "IMB", "VX231", 1800),
                new Computer("Desktop", "Apple", "iMac6", 3800),
                new Computer("Laptop", "ASUS", "A101", 1200),
                new Computer("Laptop", "ASPIRE", "AS432", 800),
                new Computer("Desktop", "ELECTRONIKA", "EL4000", 2000),
                new Computer("Laptop", "SONY", "SN786", 2400));

        System.out.println("= MoreLess then 1000");
        Map<Boolean, List<Computer>> computers = computerStream.collect(Collectors.partitioningBy(c -> c.getPrice() > 1000));

        for(Map.Entry<Boolean, List<Computer>> item : computers.entrySet()){
            if (item.getKey()) {
                showProducts("more", item);
            } else {
                showProducts("less", item);
            }
        }
        System.out.println();


        System.out.println("= groupBy");
        Stream<Computer> computerStream02 = Stream.of(new Computer("Desktop", "IMB", "VX231", 1800),
                new Computer("Desktop", "Apple", "iMac6", 3800),
                new Computer("Laptop", "ASUS", "A101", 1200),
                new Computer("Laptop", "ASPIRE", "AS432", 800),
                new Computer("Desktop", "ELECTRONIKA", "EL4000", 2000),
                new Computer("Laptop", "SONY", "SN786", 2400));
        Map<String, List<Computer>> computers02 = computerStream02.collect(Collectors.groupingBy(Computer::getType));
        for(Map.Entry<String, List<Computer>> item : computers02.entrySet()){
            System.out.println("Type: " + item.getKey());
            for(Computer c: item.getValue()) {
                System.out.printf("Type: %s, Company: %s, Model: %s %n", c.getType(), c.getCompany(), c.getModel());
            }

        }
        System.out.println();


        System.out.println("= groupBy with counting");
        Stream<Computer> computerStream03 = Stream.of(new Computer("Desktop", "IMB", "VX231", 1800),
                new Computer("Desktop", "Apple", "iMac6", 3800),
                new Computer("Laptop", "IMB", "A101", 1200),
                new Computer("Laptop", "ASPIRE", "AS432", 800),
                new Computer("Desktop", "ELECTRONIKA", "EL4000", 2000),
                new Computer("Laptop", "IMB", "SN786", 2400));
        Map<String, Long> computers03 = computerStream03.collect(Collectors.groupingBy(Computer::getCompany, Collectors.counting()));
        for(Map.Entry<String, Long> item : computers03.entrySet()){
            System.out.printf("Total value of computers in %s: %d %n", item.getKey(), item.getValue());
        }
        System.out.println();

        System.out.println("= groupBy with summingInt");
        Stream<Computer> computerStream04 = Stream.of(new Computer("Desktop", "IMB", "VX231", 1800),
                new Computer("Desktop", "Apple", "iMac6", 3800),
                new Computer("Laptop", "IMB", "A101", 1200),
                new Computer("Laptop", "ASPIRE", "AS432", 800),
                new Computer("Desktop", "ELECTRONIKA", "EL4000", 2000),
                new Computer("Laptop", "IMB", "SN786", 2400));
        Map<String, Integer> computers04 = computerStream04.collect(Collectors.groupingBy(Computer::getType, Collectors.summingInt(Computer::getPrice)));
        for(Map.Entry<String, Integer> item : computers04.entrySet()){
            System.out.printf("%s total cost: $%d %n", item.getKey(), item.getValue());
        }

        System.out.println("= groupBy with summarizingInt");
        Stream<Computer> computerStream05 = Stream.of(new Computer("Desktop", "IMB", "VX231", 1800),
                new Computer("Desktop", "Apple", "iMac6", 3800),
                new Computer("Laptop", "IMB", "A101", 1200),
                new Computer("Laptop", "ASPIRE", "AS432", 800),
                new Computer("Desktop", "ELECTRONIKA", "EL4000", 2000),
                new Computer("Laptop", "IMB", "SN786", 2400));
        Map<String, IntSummaryStatistics> computers05 = computerStream05.collect(Collectors.groupingBy(Computer::getType, Collectors.summarizingInt(Computer::getPrice)));
        for(Map.Entry<String, IntSummaryStatistics> item : computers05.entrySet()){
            System.out.printf("Value of %s: %d %n", item.getKey(), item.getValue().getCount());
            System.out.printf("Maximum price of %s: $%d %n", item.getKey(), item.getValue().getMax());
            System.out.printf("Minimum price of %s: $%d %n", item.getKey(), item.getValue().getMin());
            System.out.printf("Average price of %s: $%.2f %n", item.getKey(), item.getValue().getAverage());
            System.out.printf("Total cost of %s: $%d %n", item.getKey(), item.getValue().getSum());
            System.out.println();
        }
        System.out.println();

        System.out.println("= groupBy with Comparator");
        Stream<Computer> computerStream06 = Stream.of(new Computer("Desktop", "IMB", "VX231", 1800),
                new Computer("Desktop", "Apple", "iMac6", 3800),
                new Computer("Laptop", "IMB", "A101", 1200),
                new Computer("Laptop", "ASPIRE", "AS432", 800),
                new Computer("Desktop", "ELECTRONIKA", "EL4000", 2000),
                new Computer("Laptop", "IMB", "SN786", 2400));
        Map<String, Optional<Computer>> computers06 = computerStream06.collect(Collectors.groupingBy(Computer::getType, Collectors.minBy(Comparator.comparing(Computer::getPrice))));
        for(Map.Entry<String, Optional<Computer>> item : computers06.entrySet()){
            System.out.printf("Minimum price of %s on the model: %s %n", item.getKey(), item.getValue().get().getModel());
        }
        System.out.println();

        System.out.println("= groupBy type mappping company to list");
        Stream<Computer> computerStream07 = Stream.of(new Computer("Desktop", "IMB", "VX231", 1800),
                new Computer("Desktop", "Apple", "iMac6", 3800),
                new Computer("Laptop", "IMB", "A101", 1200),
                new Computer("Laptop", "ASPIRE", "AS432", 800),
                new Computer("Desktop", "ELECTRONIKA", "EL4000", 2000),
                new Computer("Laptop", "IMB", "SN786", 2400));
        Map<String, List<String>> computers07 = computerStream07
                .collect(Collectors.groupingBy(Computer::getType,
                        Collectors.mapping(Computer::getCompany, Collectors.toList())));
        for(Map.Entry<String, List<String>> item : computers07.entrySet()){
            System.out.printf(item.getKey());
            for (String model : item.getValue()){
                System.out.println(model);
            }
        }
        System.out.println();


    }


    private static void showProducts(String status, Map.Entry<Boolean, List<Computer>> item) {
        System.out.printf("Price is %s than $1000: %n", status);

        for(Computer c: item.getValue()){
            System.out.printf("Type: %s, Company: %s, Model: %s %n", c.getType(), c.getCompany(), c.getModel());
        }

        System.out.println();
    }

}

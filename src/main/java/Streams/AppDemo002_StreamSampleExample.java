package Streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class AppDemo002_StreamSampleExample {

    public static void main(String[] args) {
        System.out.println("== V1 ===");
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        for(String str: list){
            System.out.println(str);
        }

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Stream<String> stream001 = list.stream();
        Set<String> set001 = list.stream().collect(Collectors.toSet());


        System.out.println("== V2 ===");
        Set<String> st = Stream.of("one", "two").collect(Collectors.toSet());//eager
        List<String> list1 = Stream.of("one", "two").map(x -> x.toUpperCase()).collect(Collectors.toList());
        List<String> list2 = Stream.of("one", "two").filter(x -> x.equals("one")).collect(Collectors.toList());
        List<String> list3 = Stream.of(asList("one", "two"), asList("three", "four")).flatMap(x -> x.stream()).collect(Collectors.toList());

        int value = Stream.of(1, 2).min(Comparator.comparing(x -> x)).get();
        System.out.println("Result value = " + value);
        int value2 = Stream.of(1, 2).max(Comparator.comparing(x -> x)).get();
        System.out.println("Result value2 = " + value2);
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        System.out.println("Result count = " + count);
        int accomulator = 0;
        for(int element : new int[] {1, 2, 3}) {
            accomulator += element;
        }
        System.out.println("Result accomulator = " + accomulator);
        BinaryOperator<Integer> accumulatorOper = (acc, element) -> acc + element;
        int count2 = accumulatorOper.apply(accumulatorOper.apply(accumulatorOper.apply(0, 1), 2), 3);
        System.out.println("Result count2 = " + count2);


        Stream.of("one", "two").sorted().collect(Collectors.toList());
        Stream.of("one", "two").limit(1).collect(Collectors.toList());
        Stream.of("one", "two").distinct().collect(Collectors.toList());
        Stream.of("one", "two").skip(1).collect(Collectors.toList());
        Stream.of("one", "two").filter(x -> x.equals("one")).findAny().get();
        Stream.of("one", "two").filter(x -> x.equals("one")).findAny().isPresent();

        Stream.of(1, 2).mapToInt(x -> x).sum();
        Stream.of(2, 3).count();
        Stream.of("one", "two").peek(x -> x.toUpperCase()).findFirst().get();


    }

}

package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class JavaStreamApp {
    public static void main(String[] args) {

        List<Person> people = getPeople();
        // Imperative approach
        System.out.println("Imperative approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people){
            if(person.getGender().equals(Gender.FEMALE)){
                females.add(person);
            }
        }

        females.forEach(System.out::println);
        System.out.println("");

        // Declarative approach
        System.out.println("Declarative approach");

        //Filter
        System.out.println("Filter");
        List<Person> females02 =  people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females02.forEach(System.out::println);
        System.out.println("");

        //Sort
        System.out.println("Sort");
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println("");
        List<Person> sorted02 = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());
        sorted02.forEach(System.out::println);

        System.out.println("");

        //All match
        System.out.println("All match");

        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() >10);
        System.out.println("allMatch = " + allMatch);
        System.out.println("");

        //Any match
        System.out.println("Any match");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() >10);
        System.out.println("anyMatch = " + anyMatch);

        System.out.println("");

        //None match
        System.out.println("None match");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println("noneMatch = " + noneMatch);
        boolean noneMatch02 = people.stream()
                .noneMatch(person -> person.getName().equals("Nikolay Petrov"));
        System.out.println("noneMatch02 = " + noneMatch02);
        System.out.println("");

        //Max
        System.out.println("Max");
        Optional<Person> max = people
                .stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println("Max = " + max.get());
        System.out.println("-");
        people
                .stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(person -> {
                    System.out.println(person);
                });
        System.out.println("");

        //Min
        System.out.println("Min");
        people
                .stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(person -> {
                    System.out.println(person);
                });
        System.out.println("");

        //Group
        System.out.println("Group");
        Map<Gender, List<Person>> groupByGender = people.stream()
            .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        }));
        System.out.println("");
        Optional<String> oldestFemaleAge = people.stream()
            .filter(person -> person.getGender().equals(Gender.FEMALE))
            .max(Comparator.comparing(Person::getAge))
            .map(Person::getName);
        oldestFemaleAge.ifPresent(name -> System.out.println(name));
        System.out.println("");

    }


    private static List<Person> getPeople(){
        return List.of(
                new Person("Nikolay Petrov", 34, Gender.MALE),
                new Person("Alina Dudaeva", 33, Gender.FEMALE),
                new Person("Elena Belkich", 57, Gender.FEMALE),
                new Person("Alex Vodivaz", 15, Gender.MALE),
                new Person("John Radich", 89, Gender.MALE),
                new Person("Anna Goreva", 8, Gender.FEMALE),
                new Person("Alisa Cernya", 121, Gender.FEMALE)
        );
    }

}

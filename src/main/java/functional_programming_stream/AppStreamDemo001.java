package functional_programming_stream;


import functional_programming.AppFuncDemo001;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class AppStreamDemo001 {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Nick", Gender.MALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("John", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Alex", Gender.MALE)
        );

        Set<Gender> genders = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());
        System.out.println(genders);


        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(gender -> System.out.println(gender));

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);


        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length())
                .forEach(System.out::println);

        //Function , Consumer and etc
        System.out.println("Function , Consumer and etc");

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println; //x -> System.out.println(x);

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        System.out.println("Function , Consumer and etc and example 002");
        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);

        System.out.println("Function , Consumer and etc and example 003");
        boolean containsAnyFemales = people.stream()
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println(containsAnyFemales);

        System.out.println("Function , Consumer and etc and example 004");
        boolean containsNoneFemales = people.stream()
                .noneMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println(containsNoneFemales);
        

    }


    static class Person {

        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }

}

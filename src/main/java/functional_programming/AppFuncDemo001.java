package functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppFuncDemo001 {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Nick", Gender.MALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("John", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Alex", Gender.MALE)
        );

        //IMPERATIVE APPROACH
        System.out.println("");
        System.out.println("IMPERATIVE APPROACH");
        List<Person> femails = new ArrayList<>();
        for(Person person: people) {
            if(Gender.FEMALE.equals(person.gender)){
                femails.add(person);
            }
        }

        for(Person femail : femails){
            System.out.println(femail);
        }

        List<Person> mails = new ArrayList<>();
        for(Person person: people) {
            if(Gender.MALE.equals(person.gender)){
                mails.add(person);
            }
        }

        for(Person mail : mails){
            System.out.println(mail);
        }


        //DECLARATIVE APPROACH
        System.out.println("");
        System.out.println("DECLARATIVE APPROACH");
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        females2.forEach(System.out::println);



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

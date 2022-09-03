package StreamsLambda;

import java.util.stream.Stream;

public class AppDemo001_StreamLambda {

    public static void main(String[] args) {

        Stream<String> passwords = Stream.of("3ed45e", "23re5", "5r6r7e", "8e8ee", "99weq", "34kj5", "45gf6", "23l5k6");
        passwords.filter(password -> password.length() == 6).forEach(System.out::println);
        System.out.println("======");
        Stream<String> passwords02 = Stream.of("3ed45e", "23re5", "5r6r7e", "8e8ee", "99weq", "34kj5", "45gf6", "23l5k6");
        passwords02.skip(2).forEach(System.out::println);
        System.out.println("===");

    }

}

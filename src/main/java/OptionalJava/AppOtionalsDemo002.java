package OptionalJava;

import java.util.Optional;

public class AppOtionalsDemo002 {

    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());




        Optional<String> hello = Optional.of("hello");
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        Optional<String> helloV2 = Optional.ofNullable(null);
        String orElse = helloV2
                .map(String::toUpperCase)
                .orElse("world");
        System.out.println(orElse);

        Optional<String> helloV3 = Optional.ofNullable("Light");
        String orElseV2 = helloV3
                .map(String::toUpperCase)
                .orElse("world");
        System.out.println(orElseV2);

        Optional<String> helloV4 = Optional.ofNullable(null);
        String orElseV3 = helloV4
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // ... extra computation to retrieve the value
                    return  "world";
                });
        System.out.println(orElseV3);

//        Optional<String> helloV5 = Optional.ofNullable(null);
//        String orElseV4 = helloV5
//                .map(String::toUpperCase)
//                .orElseThrow(IllegalStateException::new);
//        System.out.println(orElseV4);

        Optional<String> helloV6 = Optional.ofNullable("1");
        helloV6.ifPresentOrElse( word -> {
            System.out.println(word);
        }, () -> {
            System.out.println("fly");
        });

        helloV6.ifPresent( word -> {
                System.out.println(word);
            });



        //==================
        System.out.println("=== Classes ===");

        Person person = new Person("Nick", "nick@gmail.com");
        System.out.println(person.getEmail().map(String::toLowerCase).orElse("email not provided"));

        person = new Person("Nick", null);
        System.out.println(person.getEmail().map(String::toLowerCase).orElse("email not provided"));


        person = new Person("Nick", "nick@gmail.com");
        System.out.println(person.getEmail().map(String::toLowerCase).orElse("email not provided"));
        if(person.getEmail().isPresent()){
            String email = person.getEmail().get();
            System.out.println(email.toLowerCase());
        }else {
            System.out.println("");
        }


    }


}

class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}

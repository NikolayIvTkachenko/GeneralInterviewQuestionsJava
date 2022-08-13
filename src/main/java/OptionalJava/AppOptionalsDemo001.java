package OptionalJava;

import java.util.Optional;
import java.util.function.Supplier;

public class AppOptionalsDemo001 {

    public static void main(String[] args) {

        Optional<String> hello = Optional.ofNullable("hello");
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());


        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(value);


        Object valueV2 = Optional.ofNullable("hello")
                .orElseGet(() -> "default value");
        System.out.println(valueV2);


        Object valueV3 = Optional.ofNullable("hello")
                .orElseThrow(() -> new IllegalStateException("Exception"));
        System.out.println(valueV3);


        Supplier<IllegalStateException> exception = () -> new IllegalStateException("Exception");
        Object valueV4 = Optional.ofNullable("hello") //null
                .orElseThrow(exception);
        System.out.println(valueV4);

        Optional.ofNullable("hello")
                .ifPresent(value00 -> {
                    //logic here
                    System.out.println(value00);
                });

        Optional.ofNullable(null) //"message"
                .ifPresentOrElse(value002 ->
                            System.out.println(value002),
                        () -> {
                            System.out.println("Something is wrong");
                        }
                );


    }

}

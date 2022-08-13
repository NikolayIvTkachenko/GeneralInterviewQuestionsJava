package functional_programming_callbacks;

import java.util.function.Consumer;

public class AppCallbacsDemo001 {

    public static void main(String[] args) {

        // callback = null
        hello("Nick", "Ivanov", null);

        //With callback
        hello("Nick", null, value -> {
            System.out.println("no lastName provided for " + value);
            //System.out.println(value);
        });

        //With callback V2
        helloV2("Nick", null, () -> System.out.println("no lastName provided"));


    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void helloV2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }

}

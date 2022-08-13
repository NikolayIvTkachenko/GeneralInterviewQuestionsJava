package functional_programming_callbacks;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AppLambdasDemo002 {

    public static void main(String[] args) {

        String res001 = upperCasNameV4.apply("Nick", 34);
        System.out.println(res001);

    }

    static Function<String, String> upperCasName = name -> name.toUpperCase();
    static Function<String, String> upperCasNameV2 = String::toUpperCase;


    static Function<String, String> upperCasNameV3 = name -> {
        //logic
        if (name.isBlank()) throw new IllegalArgumentException("");
        return name.toUpperCase();
    };


    static BiFunction<String, Integer, String> upperCasNameV4 = (name, age) -> {
        //logic
        if (name.isBlank()) throw new IllegalArgumentException("");
        System.out.println(age);
        return name.toUpperCase();
    };

}

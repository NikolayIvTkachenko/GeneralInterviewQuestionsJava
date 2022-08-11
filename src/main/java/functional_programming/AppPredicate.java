package functional_programming;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class AppPredicate {

    public static void main(String[] args) {

        System.out.println("Without predicate");
        System.out.println("070000089012");
        System.out.println("080000089012");
        System.out.println(isPhoneNumberValid("07000008901"));
        System.out.println(isPhoneNumberValid("08000008901"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000008901"));
        System.out.println(isPhoneNumberValidPredicate.test("08000008901"));
        System.out.println(isPhoneNumberValidPredicate.test("09000008301"));

        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("09000008301"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000008301"));

        System.out.println("With BiPredicate  predicate");
        System.out.println(biPredicate.test ("07000008301", "3"));

    }



    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") & phoneNumber.length() == 11;
    }


    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") & phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");


    static BiPredicate<String, String > biPredicate = (phoneNumber, containNumber) -> phoneNumber.startsWith("07") & phoneNumber.length() == 11 & phoneNumber.contains(containNumber);



}

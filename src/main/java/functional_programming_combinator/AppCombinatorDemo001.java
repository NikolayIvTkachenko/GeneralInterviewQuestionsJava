package functional_programming_combinator;

import java.time.LocalDate;

public class AppCombinatorDemo001 {

    public static void main(String[] args) {

        Customer customer = new Customer("Alice", "alice@gmail.com", "+0712342312", LocalDate.of(2000, 1, 1));

        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        System.out.println(customerValidatorService.isValid(customer));

        //If valid We can store customer in db

        // Using combinator pattern
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);
        System.out.println(result);


        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

        //Lazy call
        CustomerRegistrationValidator resultV2 = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult());
        resultV2.apply(customer);



    }


}

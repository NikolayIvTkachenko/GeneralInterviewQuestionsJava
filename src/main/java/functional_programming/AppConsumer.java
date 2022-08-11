package functional_programming;

import javax.swing.text.StyledEditorKit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class AppConsumer {

    public static void main(String[] args) {

        //Normal java function
        System.out.println("Normal java function");
        greetCustomer(new Customer("Masha", "88888"));

        //Consumer Functional interface
        System.out.println("Consumer Functional interface");
        Customer nick = new Customer("Nick", "55555");
        greetCustomerConsumer.accept(nick);

        greetCustomerConsumerV02.accept(nick, true);
        greetCustomerConsumerV02.accept(nick, false);


    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV02 = (customer, showPhonenNumber) -> System.out.println("Hello "
            + customer.customerName
            + ", thanks for registering phone number "
            + (showPhonenNumber ? customer.customerPhoneNumber: "***********"));

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello "
            + customer.customerName
            + ", thanks for registering phone number "
            + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello "
                + customer.customerName
                + ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

    }


}

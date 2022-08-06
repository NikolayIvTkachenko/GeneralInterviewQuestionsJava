package Streams.example02_map_flatmap;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DemoAppExample {

    public static void main(String[] args) {

        List<Custormer> custormerList = SimulateDb.getAll();

        //List<Customer> convert List<String> -> Data Transformation
        //mapping : customer -> customer.email, one to one
        List<String> emails = custormerList.stream().map(custormer -> custormer.getEmail()).collect(Collectors.toList());
        System.out.println(emails);

        //mapping : customer -> customer.phones, one to many
        List<List<String>> phoneNumbers = custormerList.stream().map(custormer -> custormer.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        // mapping : customer -> phone Numbers
        List<String> collectPhones = custormerList.stream()
                .flatMap(custormer -> custormer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(collectPhones);

        // mapping : customer -> phone Numbers, filter
        List<String> collectPhonesFilter = custormerList.stream()
                .flatMap(custormer -> custormer.getPhoneNumbers().stream().filter(phone -> phone.equals("38112453218")))
                .collect(Collectors.toList());
        System.out.println(collectPhonesFilter);

        // mapping : customer -> phone Numbers, filter custom text
        Predicate<String> con001 = str -> str.matches("^381[0-9]*$");
        List<String> collectPhonesFilter02 = custormerList.stream()
                .flatMap(custormer -> custormer.getPhoneNumbers().stream().filter(con001))
                .collect(Collectors.toList());
        System.out.println(collectPhonesFilter02);

    }





}

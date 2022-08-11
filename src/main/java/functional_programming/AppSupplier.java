package functional_programming;

import java.util.List;
import java.util.function.Supplier;

public class AppSupplier {

    public static void main(String[] args) {

        System.out.println(getDbConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());

        System.out.println(getDBConnectionUrlSupplierV02.get());





    }

    static String getDbConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getDBConnectionUrlSupplierV02 = () -> List.of("jdbc://localhost:5432/users", "jdbc://localhost:5432/employee");

}

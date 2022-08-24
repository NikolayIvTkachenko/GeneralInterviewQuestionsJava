package lambda;



public class LambdaAppDemo001_Operation {

    public static void main(String[] args) {

        System.out.println("== V1 ===");
        Operation operation = new Operation() {
            @Override
            public double getResult(double value1, double value2) {
                return value1 + value2;
            }
        };
        System.out.println(operation.getResult(2.0, 2.0));


        System.out.println("== V2 ===");
        Operation lambda = (value1, value2) -> value1 + value2;
        System.out.println(lambda.getResult(2.0, 2.0));

        System.out.println("== V3 ===");
        Printer printer = message -> System.out.println(message);
        printer.printall("Hello everybody!");

        System.out.println("== V4 ===");
        Factorial factorial = value -> {
            int result = 1;
            for(int i = 1; i <= value; ++i){
                result *= i;
            }
            return result;
        };
        System.out.println(factorial.getResult(5));






    }


}

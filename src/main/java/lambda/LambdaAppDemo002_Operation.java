package lambda;

public class LambdaAppDemo002_Operation {

    private static double value1 = 2.0, value2 = 2.0;

    public static void main(String[] args) {

        System.out.println("== V5 ===");
        OperationV2 lambda = () -> value1 + value2;
        System.out.println(lambda.getResult());

        System.out.println(value1);
        System.out.println(value2);


        System.out.println("== V6 ===");
        OperationV2 operationV2 = () -> {
            value1 = 100;
            return value1 + value2;
        };
        System.out.println(operationV2.getResult());

        System.out.println(value1);
        System.out.println(value2);


        System.out.println("== V7 ===");
        double value11 = 2.0, value22 = 2.0;
        OperationV2 operationV2_02 = () -> {
            //value11 = 100; // - not compile
            return value11 + value22;
        };
        System.out.println(operationV2_02.getResult());

        System.out.println(value11);
        System.out.println(value22);



    }


}

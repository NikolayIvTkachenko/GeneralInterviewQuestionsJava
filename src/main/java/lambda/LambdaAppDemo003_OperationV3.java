package lambda;

public class LambdaAppDemo003_OperationV3 {

    public static void main(String[] args) {

        OperationV3<Integer> addition = (value1, value2) -> value1 + value2;
        System.out.println(addition.getResult(2, 3 ));

        OperationV3<String> concatenation = (value1, value2) -> value1 + value2;
        System.out.println(concatenation.getResult("2", "3"));





    }




}

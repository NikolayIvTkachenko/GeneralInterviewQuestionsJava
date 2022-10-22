package Algoritms_Sample;

public class AppTasks001 {

    public static void main(String[] args) {
        //FizzBuzz. Вывести в консоль числа от 1 до 100, разделив их запятой с пробелом.
        //При этом все кратные 3 заменить на слово Fizz, все кратные 5 на Buzz, а кратные и 3 и 5 одновременно на FizzBuzz

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 100; i++){

            if (i == 100) result.append("Buzz");
            else if (i % 3 == 0 && i % 5 == 0) result.append("FizzBuzz, ");
            else if (i % 3 == 0) result.append("Fizz, ");
            else if (i % 5 == 0) result.append("Buzz, ");
            else result.append(i).append(", ");
        }
        System.out.println(result);
    }
}

//else if (i % 5 == 0 && i == 100) result += "Buzz"   //\(i)  // ${i}

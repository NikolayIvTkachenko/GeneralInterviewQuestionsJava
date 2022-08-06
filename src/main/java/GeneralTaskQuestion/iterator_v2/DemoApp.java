package GeneralTaskQuestion.iterator_v2;

import GeneralTaskQuestion.iterator_v2.CustomListIterator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DemoApp {

    public static void main(String[] args) {

        //Создаем лист с Integer
        //List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        List<Integer> list = Arrays.asList(1);


        //Создать итератор
        CustomListIterator customListIterator = new CustomListIterator(list);

        //Тестирование
        //List<Integer> next = customListIterator.next();

        Stream.generate(() -> null)
                .takeWhile(x -> customListIterator.hasNext())
                .map(t -> customListIterator.next())
                .forEach(System.out::println);
    }
}

package GeneralTaskQuestion.iterator_v3;

import GeneralTaskQuestion.iterator_v2.CustomListIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class DemoApp {



    public static void main(String[] args) {

        //Создаем лист с Integer
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //Создать итератор
        //Iterator<List<Integer>> iterator = list.stream().distinct();


        GeneralTaskQuestion.iterator_v2.CustomListIterator customListIterator = new CustomListIterator(list);

        //Тестирование
        //List<Integer> next = customListIterator.next();

        Stream.generate(() -> null)
                .takeWhile(x -> customListIterator.hasNext())
                .map(t -> customListIterator.next())
                .forEach(System.out::println);


        //Testing 001
        //
//        Stream.generate(customListIterator::next)
//                .takeWhile((v) -> customListIterator.hasNext())
//                .forEach(System.out::println);

    }

}

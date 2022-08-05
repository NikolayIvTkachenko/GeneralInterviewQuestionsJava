package GeneralTaskQuestion.iterator_v1;

import java.util.ArrayList;
import java.util.List;

public class DemoApp {

    public static void main(String[] args) {


        //Создаем лист с Integer
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        //Создать итератор
        CustomListIterator customListIterator = new CustomListIterator(list);

        //Тестирование
        //AnswerResult next = customListIterator.next();

        while (customListIterator.hasNext()){
            System.out.println("Answer return: " + customListIterator.next());
        }

    }
}
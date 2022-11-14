package Algoritms_LinkedList;

//Односвязный список.
//
//Структура односвязного списка
//Содержит Head, Tail
//(Data/Next) -> (Data/Next) -> (Data/Next) -> (Data/Next) ->
//Example: Head -> (1-Data/Next) -> (2-Data/Next) -> (3-Data/Next) -> (4-Data/Next) -> (5-Data/Next) -> (6-Data/Next) -> (7-Data/Next) -> Tail
//Последовательный доступ - подразумевается, что проходим по списку один объект за другим
//Вставка новых элементов - o(1)
//Удаление элементов - O(1)
//Произвольный доступ - O(n)
//Развернутый односвязный список: Tail -> (7-Data/Next) -> (6-Data/Next) -> (5-Data/Next) -> (4-Data/Next) -> (3-Data/Next) -> (2-Data/Next) -> (1-Data/Next) -> Head
//

public class AppTasks001_LinkedList_TurnoverSingleLinkedList {

    public static void main(String[] args) {

        SingleLinkList<Person> personList = new SingleLinkList<>();
        personList.addToEnd(new Person(134, "Nikolay Petrov", "+38188990001"));
        personList.addToEnd(new Person(145, "Nikolay Petrov", "+38188990022"));
        personList.addToEnd(new Person(149, "Nikolay Petrov", "+38188994321"));
        personList.addToEnd(new Person(201, "Nikolay Petrov", "+38188976594"));
        personList.addToEnd(new Person(224, "Nikolay Petrov", "+38184499001"));
        personList.addToEnd(new Person(289, "Nikolay Petrov", "+38185590003"));
        personList.addToEnd(new Person(302, "Nikolay Petrov", "+38188191009"));
        personList.addToEnd(new Person(309, "Nikolay Petrov", "+38188292008"));
        personList.addToEnd(new Person(356, "Nikolay Petrov", "+38188493007"));

        System.out.println("===== Show List =====");
        for(Person person: personList){
            System.out.println(person);
        }

        System.out.println("");
        System.out.println("===== Show Reverse List =====");
        personList.reverse();
        for(Person person: personList){
            System.out.println(person);
        }
    }
}



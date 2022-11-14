package Algoritms_LinkedList;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SingleLinkList<T> implements Iterable<T> {

    ListItem<T> head;
    ListItem<T> tail;

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            ListItem<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private static class ListItem<T> {
        T data;
        ListItem<T> next;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addToEnd(T item) {
        ListItem<T> newItem = new ListItem<>();
        newItem.data = item;

        if(isEmpty()) {
            head = newItem; //Если связный список пустой, то значение head
            tail = newItem; // и tail указывают на один объект
        } else {
            tail.next = newItem; //делаем ссылку из предыдущего конца связного списка на новый объект
            tail = newItem; //Присваеваем концу списка значение нового объекта
        }
    }

    //1 -> 2 -> 3 -> null  = direct
    //null <- 1 <- 2 <- 3  = reversed
    public void reverse(){
        if(!isEmpty() && head.next != null) {
            tail = head; //Присваиваем хвостовой части первую часть, - заголовок
            ListItem<T> current = head.next; // текущим объектом становиться следующий элемент от старого (неразвернутого) заголовка
            head.next = null; //ссылка (неразвернутого) старого заголовка обнуляется

            while(current != null) { // Пока текщий элмент не пустой выполняеи цикл
                ListItem<T> next = current.next;
                current.next = head;
                head = current;
                current = next;
            }

            System.out.println("head = " + head.data.toString());
            System.out.println("tail = " + tail.data.toString());
        }
    }

    //1 -> 2 -> 3 -> null  = direct , head=1, tail=3
    //null <- 1 <- 2 <- 3  = reversed ,  head=3, tail=1
    public void reverseV2(){
        if(!isEmpty() && head.next != null) {
            tail = head; //Первый элемент становиться последним
            ListItem<T> current = head.next;
            head.next = null; //заголовок ни куда не ссылется

            while(current != null){
                ListItem<T> next = current.next;
                current.next = head;
                head = current;
                current = next;
            }

        }
    }

}

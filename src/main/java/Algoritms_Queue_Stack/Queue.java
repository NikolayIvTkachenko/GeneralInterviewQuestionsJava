package Algoritms_Queue_Stack;

public interface Queue<T> {

    void add(T item); //добавить элементв конец очереди
    T remove(); //Извлечение элемента из начала очереди
    boolean isEmpty(); //Проверка на пустото

}

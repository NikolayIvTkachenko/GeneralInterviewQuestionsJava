package GeneralTaskQuestion.iterator_v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomListIterator implements Iterator<List<Integer>>{

    private List<Integer> list;
    private int counter;
    private final int maxReturnValues = 3;
    public CustomListIterator(List<Integer> list){
        this.counter = 0;
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (counter < list.size()) return true;
        return false;
    }

    //Возвращать три значения, либо если меньше то остаток
    @Override
    public List<Integer> next() {

        List<Integer> listReturn = new ArrayList<>();
        Integer counterMaxReturnValue = counter + maxReturnValues;

        Integer CreteriaValue = counterMaxReturnValue - list.size();
        if(CreteriaValue >= 3) {
            throw new NoSuchElementException("The Array does not contain elements. CriteriaValue = " + 3);
        }

        if(counterMaxReturnValue>list.size()){
            counterMaxReturnValue = list.size();
        }

        for(int i = counter; i < counterMaxReturnValue; i++ ){
            listReturn.add(list.get(i));
        }

        //AnswerResult answerResult = new AnswerResult(listReturn);
        counter += maxReturnValues;

        return listReturn; //answerResult; //listReturn;
    }
}
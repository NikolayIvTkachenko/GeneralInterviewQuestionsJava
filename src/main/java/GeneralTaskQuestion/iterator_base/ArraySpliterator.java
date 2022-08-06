package GeneralTaskQuestion.iterator_base;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArraySpliterator implements Spliterator<String> {

    private String[] arrayToSplit;
    int count = 0;
    // Constructor to access Array this is the source
    public ArraySpliterator(String[] arrayToSplit) {
        this.arrayToSplit = arrayToSplit;
    }
    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        if (count <= arrayToSplit.length - 1) {
            action.accept(arrayToSplit[count]);
            count++;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Spliterator<String> trySplit() {
        return null;
    }
    @Override
    public long estimateSize() {
        return arrayToSplit.length;
    }
    @Override
    public int characteristics() {
        // For Simplicity lets use the characteristics of a List as base
        return Arrays.asList(arrayToSplit).stream().spliterator().characteristics();
    }
}


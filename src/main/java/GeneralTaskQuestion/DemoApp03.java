package GeneralTaskQuestion;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DemoApp03 {

    // Generic method to create a sequential stream from an iterator
    public static <T> Stream<T> iteratorToStream(Iterator<T> iterator)
    {
        // Characteristics of this spliterator's elements
        int characteristics = Spliterator.ORDERED | Spliterator.NONNULL;

        // convert the iterator into a Spliterator
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(
                iterator, characteristics);

        // flag to make the resulting stream run sequentially or in parallel
        boolean parallel = false;

        // turn spliterator into an ordered, sequential stream
        return StreamSupport.stream(spliterator, parallel);
    }

    public static void main(String[] args)
    {
        Iterator<String> itr = Arrays.asList("A", "B", "C", "D").iterator();
        Stream<String> stream = iteratorToStream(itr);

        System.out.println(stream.collect(Collectors.toList()));
    }

}

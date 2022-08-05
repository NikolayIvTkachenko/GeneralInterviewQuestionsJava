package GeneralTaskQuestion;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DemoApp04 {

    // Generic method to create a sequential stream from an iterator
    public static <T> Stream<T> iteratorToStream(Iterator<T> iterator)
    {
        // get an Iterable from an Iterator
        Iterable<T> iterable = () -> iterator;

        // flag to make the resulting stream run sequentially or in parallel
        boolean parallel = false;

        // get Spliterator from Iterable and turn it into a sequential stream
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

    public static void main(String[] args)
    {
        Iterator<String> itr = Arrays.asList("A", "B", "C", "D").iterator();
        Stream<String> stream = iteratorToStream(itr);

        System.out.println(stream.collect(Collectors.toList()));
    }

}

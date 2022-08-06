package GeneralTaskQuestion;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DemoApp05 {

    // Function to get the Stream
    public static <T> Stream<T>
    getStreamFromIterator(Iterator<T> iterator)
    {

        // Convert the iterator to Spliterator
        Spliterator<T>
                spliterator = Spliterators
                .spliteratorUnknownSize(iterator, 0);

        // Get a Sequential Stream from spliterator
        return StreamSupport.stream(spliterator, false);
    }

    // Driver code
    public static void main(String[] args)
    {

        // Get the Iterator
        Iterator<Integer>
                iterator = Arrays.asList(1, 2, 3, 4, 5)
                .iterator();

        // Get the Stream from the Iterator
        Stream<Integer>
                stream = getStreamFromIterator(iterator);

        // Print the elements of stream
        stream.forEach(s -> System.out.println(s));
    }

}

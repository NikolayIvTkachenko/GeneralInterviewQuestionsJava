package StreamsLambda;

import java.util.stream.Stream;

public class AppDemo002_StreamFilm {

    public static void main(String[] args) {

        Stream<Film> filmStream = Stream.of(new Film("Aliens 2", 200), new Film("Terminator 2", 300));
        filmStream.map(Film::getTitle).forEach(System.out::println);

    }

}

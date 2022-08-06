package Streams.example02_map_flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimulateDb {

    public static List<Custormer> getAll(){
        return Stream.of(
                new Custormer(101, "nick", "nick@mail.rs", Arrays.asList("38111564323", "38112453218")),
                new Custormer(102, "marina", "marina@mail.rs", Arrays.asList("38111564778", "38112455123")),
                new Custormer(103, "demon", "demon@mail.rs", Arrays.asList("38111565678", "38112450980")),
                new Custormer(104, "angel", "angel@mail.rs", Arrays.asList("38011598076", "38112453208"))
                ).collect(Collectors.toList());
    }

}

package src.ch00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {

    public static void main(String[] args) {
        // Array Stream
        String[] array = {"A", "B", "C"};
        Stream<String> arrayStream = Arrays.stream(array); // A B C
        Stream<String> arrayStreamPart = Arrays.stream(array, 1, 2); // B C

        // Collection Stream
        List<String> list = Arrays.asList("A", "B", "C");
        Stream<String> listStream = list.stream();
        // 병렬 처리용 Stream
        Stream<String> listParallelStream = list.parallelStream();

        // empty Stream
        Stream<Object> emptyStream = Stream.empty();
        // Stream builder
        Stream<String> builderStream = Stream.<String>builder()
                .add("A").add("B").add("C")
                .build();

        // generate
        Stream<String> generateStream = Stream.generate(() -> "A").limit(5); // A A A A A
        // iterate
        Stream<Integer> iterateStream = Stream.iterate(10, v -> v + 2).limit(6); // 10 12 14 16 18 20
    }
}

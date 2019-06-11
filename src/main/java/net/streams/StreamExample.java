package net.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            myList.add(i);
        }

        // sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        // parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        Stream<Integer> highNums = parallelStream.filter(p -> p < 10);
        highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p < 10);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

    }
}

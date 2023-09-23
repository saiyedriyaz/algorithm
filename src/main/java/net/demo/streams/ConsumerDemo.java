package net.demo.streams;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerDemo {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1,2,3);
        Stream<Integer> s2 = Stream.of(1,2,3);
        /*Consumer<Integer> c1 = System.out::print;
        Consumer<Integer> c2 = (m) -> {
            System.out.println(" double="+m * 2);
        };
        Consumer<Integer> c3 = (m) -> {
            System.out.print(" negative="+m * -1);
        };
        s1.forEach(c1.andThen(c3).andThen(c2));*/

        System.out.println(s1.collect(Collectors.averagingInt(i->i)));
        System.out.println(s2.parallel().mapToDouble(i -> i).average().getAsDouble());
    }
}

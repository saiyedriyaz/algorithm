package net.demo.streams;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

public class StreamFactory {
    public static void main(String[] args) {
       /* var fruitList = List.of("orange", "apple", "Lemon", "Respberry");
        var typeList = List.of("juice","pie","Ice","Tart");
        var stream = IntStream.range(0, Math.min(fruitList.size(), typeList.size()))
                .mapToLong((i) -> fruitList.get(i).length() * typeList.get(i).length());
        System.out.println(stream);
        stream.forEach(System.out::println);*/

        /*Function<Integer, Integer> f = n -> n*2;
        Function<Integer, Integer> negativeFun =  i -> {
                if(i > 0) {
                    return i * -1;
                }
                return i;
        };
        System.out.println(negativeFun.apply(-5));*/
        myLambda();
        var r = new Random();
        AtomicInteger counter = new AtomicInteger(1);
        DoubleStream.generate(r::nextDouble).limit(100).forEach(n -> {
            System.out.println(counter.getAndIncrement() + ":" + n);
        });
        DoubleStream.generate(r::nextDouble).limit(100).forEach(withCounter((i, n) -> System.out.println(i + ":" + n)));
    }

    public static DoubleConsumer withCounter(BiConsumer<Integer, Double> consumer) {
        AtomicInteger counter = new AtomicInteger(1);
        return item -> consumer.accept(counter.getAndIncrement(), item);
    }

    static void myLambda() {
        final int i = 10;
        Supplier<Integer> foo = () -> i;
        System.out.println(foo.get());
    }
}

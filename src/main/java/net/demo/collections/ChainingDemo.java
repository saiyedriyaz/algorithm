package net.demo.collections;

import java.util.List;
import java.util.function.Consumer;

public class ChainingDemo {
    public static void main(String[] args) {
        Consumer<String> printC = System.out::println;
        Consumer<String> uppperC = printC.andThen(String::toUpperCase);
        List<String> fruits = List.of("Apple", "Banana", "Cherry");
        fruits.forEach(uppperC);
    }
}

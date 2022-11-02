package net.demo.streams;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class ReducerDemo {
    public static void main(String[] args) {
        java.util.List<String> names = List.of("SUNDAY", "MONDAY", "TUESDAY");
        System.out.println(names.stream().mapToInt(String::length).sum());

        BinaryOperator<String> bop = (n1, n2) -> n1 + n2;
        IntBinaryOperator bopSum = (n1, n2) -> n1 + n2; // Integer::sum;
        String concated = names.stream().reduce( "", bop::apply); // (s1, s2) -> bop.apply(s1,s2)
        var reduced = names.stream().mapToInt(String::length).reduce(bopSum);
        System.out.println(concated);
        System.out.println(reduced);

        BiFunction<String, String, Integer> sumL = (s1, s2) -> s1.length() + s2.length();

    }
}
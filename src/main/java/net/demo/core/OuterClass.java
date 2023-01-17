package net.demo.core;

import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class OuterClass {
    public static void main(String[] args) {
        DoubleFunction d = (x) -> (x / 2);
        System.out.println(d.apply(5.0));

        DoubleConsumer dc = p1 -> System.out.println(p1);
        dc.accept(5.0);
    }
}

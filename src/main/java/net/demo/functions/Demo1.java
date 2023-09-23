package net.demo.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;

public class Demo1 {

    static class MyWrapper <T> {
        MyWrapper(T value) {
            this.value = value;
        }
        T value;
        T getT() {
            return this.value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static void main(String[] args) {
        /*List<Integer> l1 = Arrays.asList(1, 2, 3);
        System.out.println(l1.stream().mapToInt(x -> x).sum()); //6

        System.out.println(l1.stream().reduce(0, (a, b) -> a + b)); // 6

        System.out.println(l1.stream().collect(Collectors.summarizingInt(value -> value)).getSum()); //6

        System.out.println(l1.stream().collect(Collectors.mapping(x -> x,
                Collectors.summarizingInt(x -> x))).getSum()); // 6*/

        List<Integer> l11 = new ArrayList<>();
        l11.add(000);
        l11.add(Integer.valueOf(1));

        List<Double> l22 = new ArrayList<>();
        l22.add(12.34D);
        l22.add(Double.valueOf(5.5d));

        List<String> l33 = new ArrayList<>();
        l33.add("111");

        //printMe(l11);
        //printMe(l22);
        //printMe(l33); // error

        var dList = new ArrayList<>(Arrays.asList(new Demo1.MyWrapper(4.4d)));
        andAndPintT(new Demo1.MyWrapper(5.5d), dList);

        var iList = new ArrayList<>(Arrays.asList(new Demo1.MyWrapper(786)));
        andAndPintT(new Demo1.MyWrapper(787), iList);

        var sList = new ArrayList<>(Arrays.asList(new Demo1.MyWrapper("january")));
        andAndPintT(new Demo1.MyWrapper("february"), sList); // error
    }

    public static void printMe(List<? extends Number> numList) {
        numList.forEach(System.out::println);
        //numList.add(7.7D); // error
    }

    public static <T> void andAndPintT(T value, List<T> numList) {
        numList.add(value); // okay
        numList.forEach(System.out::println);
    }
}

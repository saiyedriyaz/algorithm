package net.demo.collections;

import java.util.ArrayList;
import java.util.List;

public class ImmutableDemo {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(0,1);
        numList.add(0,2);
        numList.add(0,3);
        System.out.println(numList);

        var col = List.of(numList);
        numList.add(4);

        System.out.println(numList);
        System.out.println(col);

    }
}

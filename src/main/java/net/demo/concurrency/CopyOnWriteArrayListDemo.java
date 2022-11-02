package net.demo.concurrency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        //List<Integer> favNumbers = new ArrayList<>(List.of(4, 3, 42));
        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
        for (var n : favNumbers) {
            System.out.print(n + " ");
            favNumbers.add(9);
        }
        System.out.println();
        System.out.println("list: " + favNumbers);
        System.out.println("Size: " + favNumbers.size());
    }
}

package net.demo.challanges;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        long number = 50;
        System.out.println("Fibonacci series upto " + number + " numbers : ");
        //printing Fibonacci series upto number
        long beg = System.currentTimeMillis();
        // System.out.println(fibonacci(number) + " ");
        for (int i = 1; i <= number; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end - beg);
    }

    static Map<Long, Long> cache = new HashMap<>();

    static long fibonacci(long number) {
        /*if (cache.containsKey(number)) {
            return cache.get(number);
        } else*/ if (number < 2) {
            return number;
        } else {
            long computed = fibonacci(number - 1) + fibonacci(number - 2);
            cache.put(number, computed);
            return computed;
        }
    }
}

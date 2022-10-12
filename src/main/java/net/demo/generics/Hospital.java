package net.demo.generics;


import java.util.List;

public class Hospital {
    public static void main(String[] args) {
        System.out.println(firstElementInArray(List.of("one", "two")));
        System.out.println(firstElementInArray(List.of(1,2,3)));
        System.out.println(firstElementInArray(List.of(1.1,2.2,3.3)));
    }

    public static <T> String firstElementInArray(List<T> arrayInput) {
        if(arrayInput == null || arrayInput.isEmpty()) {
            return null;
        }
        return arrayInput.get(0).toString();
    }
}

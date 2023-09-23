package net.demo.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

interface Foo {
    static void bar() {

    }
}
public class UnaryOperatorDemo {
    private static int a;
    private int b;
    public static void main(String[] args) {
        String val1 = "hello";
        UnaryOperator<String> uo1 = s1->s1.concat(val1); //1
        new UnaryOperatorDemo();
    }

    public UnaryOperatorDemo() {
        System.out.println("a="+a);
        UnaryOperator<String> func3 = String::toUpperCase;
        List<String> letters = Arrays.asList("j", "a", "v","a");
        letters.replaceAll(func3);
        letters.forEach(this:: printMe);
    }

    private void printMe(String s) {
        System.out.print(s + a);
    }
}

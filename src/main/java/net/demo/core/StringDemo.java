package net.demo.core;

public class StringDemo {
    public static void main(String[] args) {
        String first = "rat" + 1;
        String second = "r" + "a" + "t" + "1";
        String third = "r" + "a" + "t" + new String("1");
        System.out.println(first == second); // true
        System.out.println(first == second.intern()); // true
        System.out.println(first == third); // false
        System.out.println(first == third.intern()); // true

        String s1 = "+";
        String s2 = s1.repeat(3);
        System.out.println(s2.equals("+++")+":"+(s2 == "+++"));

        String[] s = "BEVERAGEBEVERAGE".split("E",2);
        System.out.println(s[0]);
    }
}

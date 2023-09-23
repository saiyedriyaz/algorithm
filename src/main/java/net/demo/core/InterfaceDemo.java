package net.demo.core;

import java.util.*;

interface IA {
    Set m1(Collection input);
}

interface IB extends IA {
    default HashSet m1(Collection input) {
        System.out.println("this is default");
        return new HashSet();
    }
    static void m2() {
        System.out.println("static method of IB");
    }
}
public class InterfaceDemo implements IB {
    /*@Override
    public void m1() {
        System.out.println("this is implemented");
    }*/

    public static void main(String[] args) {
        IB ib = new InterfaceDemo();
        ib.m1(null);
        IB.m2();
    }
}